package com.beksar.androidci

import android.app.Application
import android.content.Context
import com.google.android.play.core.splitcompat.SplitCompat

class App: Application() {

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase)
        SplitCompat.install(this)
    }
}