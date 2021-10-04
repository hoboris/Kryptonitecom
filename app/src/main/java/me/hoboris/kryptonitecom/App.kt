package me.hoboris.kryptonitecom

import android.app.Application
import android.content.Context
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    companion object {
        lateinit var applicationContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        Companion.applicationContext = this
    }
}