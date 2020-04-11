package com.vedmitryapps.model

import com.vedmitryapps.model.Exhibit

interface ExhibitsLoader {
    fun getExhibitList():List<Exhibit>
}