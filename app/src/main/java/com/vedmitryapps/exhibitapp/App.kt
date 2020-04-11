package com.vedmitryapps.exhibitapp

import android.app.Activity
import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.vedmitryapps.exhibitapp.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this@App)
        Fresco.initialize(this)
    }

    override fun activityInjector() = activityInjector

}