package com.vedmitryapps.fileexhibitsloader

import android.content.Context
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.vedmitryapps.model.Exhibit
import com.vedmitryapps.model.ExhibitsLoader
import java.io.IOException
import java.io.InputStream

class FileExhibitsLoader(val context: Context) : ExhibitsLoader {

    companion object {
        const val FILE_NAME = "file.json"
    }

    override fun getExhibitList(): List<Exhibit> {
        val result = mutableListOf<Exhibit>()
        loadJSONFromAsset()?.let { result.addAll(fromJson(it).array) }
        return result
    }

    fun loadJSONFromAsset(): String? {
        var json: String? = null
        json = try {
            val inputStream: InputStream = context.assets.open(FILE_NAME)
            val size: Int = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }
        return json
    }

    private fun fromJson(json: String): ExhibitResponse {
        return Gson().fromJson<ExhibitResponse>(json, ExhibitResponse::class.java)
    }
}

data class ExhibitResponse(
    @SerializedName("list")
    var array: List<Exhibit> = listOf()
)