package com.beksar.androidci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.beksar.androidci.databinding.ActivityMainBinding
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest
import com.google.android.play.core.splitinstall.model.SplitInstallSessionStatus

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var manager: SplitInstallManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = SplitInstallManagerFactory.create(this)

        binding.version.text = BuildConfig.VERSION_NAME

        binding.installTime.setOnClickListener {
            val intent = Intent()
            intent.setClassName(
                BuildConfig.APPLICATION_ID,
                "com.example.installtime.InstallTimeActivity"
            );
            startActivity(intent)
        }

        binding.onDemandOnly.setOnClickListener {

            val request = SplitInstallRequest.newBuilder()
                .addModule("ondemandonly")
                .build()
            val moduleAssets = "ondemandonly"
            manager.startInstall(request)
                .addOnCompleteListener { showMessage("Module $moduleAssets installed") }
                .addOnSuccessListener { showMessage("Loading $moduleAssets") }
                .addOnFailureListener { showMessage("Error Loading $moduleAssets") }
//
//            if (SplitInstallManagerFactory.create(this).installedModules.contains("ondemandonly")) {
//                startActivity(intent)
//            } else {
//                val request = SplitInstallRequest.newBuilder()
//                    .addModule("ondemandonly")
//                    .build()
//                SplitInstallManagerFactory.create(this).startInstall(request).addOnSuccessListener {
//                    showMessage("Success$it")
//                }.addOnFailureListener {
//                    showMessage("Failure" + it.message)
//                }.addOnCompleteListener {
//                    showMessage("Complete ${it.isComplete} Successful ${it.isSuccessful} ")
//                    if (it.isComplete && it.isSuccessful) {
//                        when(it.result){
//                            SplitInstallSessionStatus.INSTALLED -> {
//                              showMessage("INSTALLED")
//                            }
//                            SplitInstallSessionStatus.FAILED -> {
//                                showMessage("FAILED")
//                            }
//                            SplitInstallSessionStatus.INSTALLING -> {
//                                showMessage("INSTALLING")
//                            }
//                        }
////                        val intent = Intent()
////                        intent.setClassName(
////                            BuildConfig.APPLICATION_ID,
////                            "com.example.ondemandonly.OnDemandActivity"
////                        )
////                        startActivity(intent)
//                    }
//                    showMessage(" Result ${it.result}")
//                }


//            }
//            startActivity(intent)
        }

        binding.specific.setOnClickListener {
            val intent = Intent()
            intent.setClassName(
                BuildConfig.APPLICATION_ID,
                "com.example.specific.SpecificActivity"
            );
            startActivity(intent)
        }

    }


    private fun showMessage(text: String?) {
        Toast.makeText(this, text ?: "", Toast.LENGTH_SHORT).show()
    }
}