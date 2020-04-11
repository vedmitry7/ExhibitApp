package com.vedmitryapps.exhibitapp.di.module

import com.vedmitryapps.exhibitapp.screen.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector()
    abstract fun contributeMainActivity(): MainActivity
}