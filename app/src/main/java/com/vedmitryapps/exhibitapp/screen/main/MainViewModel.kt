package com.vedmitryapps.exhibitapp.screen.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vedmitryapps.fileexhibitsloader.FileExhibitsLoader
import com.vedmitryapps.model.Exhibit
import javax.inject.Inject

class MainViewModel @Inject constructor(val fileExhibitsLoader: FileExhibitsLoader) : ViewModel() {

    val data = MutableLiveData<List<Exhibit>>()

    fun getExhibits() {
        data.value = fileExhibitsLoader.getExhibitList()
    }

}