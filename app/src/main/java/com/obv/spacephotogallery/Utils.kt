package com.obv.spacephotogallery

import android.content.Context
import com.obv.spacephotogallery.data.ImageDetail
import java.io.IOException

/**
 * From Internet, source: https://bezkoder.com/kotlin-android-read-json-file-assets-gson/
 */
fun getJsonDataFromAssets(context: Context): String? {
    val jsonString: String
    try {
        jsonString = context.assets.open("obvious_data.json").bufferedReader().use { it.readText() }
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        return null
    }
    return jsonString
}

class ingList{
    companion object {
        lateinit var sortedImageList : List<ImageDetail>
    }
}