package com.vedmitryapps.model

import com.google.gson.annotations.SerializedName

data class Exhibit(@SerializedName("title") var title: String,
                   @SerializedName("images") var images: List<String>)