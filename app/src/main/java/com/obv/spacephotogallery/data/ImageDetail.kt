package com.obv.spacephotogallery.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageDetail(
    val copyright: String,
    val date: String,
    val explanation: String,
    val title: String,
    val url: String,
    val hdurl: String,
    val media_type: String,
    val service_version: String
)
