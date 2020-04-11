package com.vedmitryapps.exhibitapp.di.module

import com.vedmitryapps.exhibitapp.App
import com.vedmitryapps.fileexhibitsloader.FileExhibitsLoader
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Provides
    @Singleton
    fun providesFileExhibitsLoader(app: App): FileExhibitsLoader {
        return FileExhibitsLoader(app.applicationContext)
    }

}