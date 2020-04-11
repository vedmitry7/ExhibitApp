package com.vedmitryapps.exhibitapp.di

import com.vedmitryapps.exhibitapp.App
import com.vedmitryapps.exhibitapp.di.module.DataModule
import com.vedmitryapps.exhibitapp.di.module.MainActivityModule
import com.vedmitryapps.exhibitapp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        ViewModelModule::class,
        DataModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: App): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}