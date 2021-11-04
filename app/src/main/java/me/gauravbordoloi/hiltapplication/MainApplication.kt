package me.gauravbordoloi.hiltapplication

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import me.gauravbordoloi.sdk.SDK
import javax.inject.Inject

@HiltAndroidApp
class MainApplication: Application() {

    @Inject
    lateinit var sdk: SDK

    override fun onCreate() {
        super.onCreate()

        sdk.init(applicationContext)

    }

}