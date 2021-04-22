package com.beksar.androidci

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.beksar.androidci.databinding.ActivityMainBinding
import com.google.android.play.core.splitinstall.SplitInstallManager
import com.google.android.play.core.splitinstall.SplitInstallManagerFactory
import com.google.android.play.core.splitinstall.SplitInstallRequest

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
            val intent = Intent()
            intent.setClassName(
                BuildConfig.APPLICATION_ID,
                "com.example.ondemandonly.OnDemandActivity"
            )


            if (SplitInstallManagerFactory.create(this).installedModules.contains("ondemandonly")) {
                startActivity(intent)
            } else {
                val request = SplitInstallRequest.newBuilder()
                    .addModule("ondemandonly")
                    .build()
                SplitInstallManagerFactory.create(this).startInstall(request).addOnSuccessListener {
                    showMessage(it.toString())
                    startActivity(intent)
                }.addOnFailureListener {
                    showMessage(it.message)
                }


            }
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