package com.colecciono.micoleccion

import android.app.Application
import android.content.res.Configuration
import android.util.Log

class ColeccionApplication: Application(){
    val tag = "ColeccionApplication"
    override fun onCreate() {
        super.onCreate()
        Log.d(tag, "ColeccionApplication onCreate")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.d(tag, "ColeccionApplication onConfigurationChanged ${newConfig.orientation}")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.d(tag, "ColeccionApplication onTerminate")
    }
}