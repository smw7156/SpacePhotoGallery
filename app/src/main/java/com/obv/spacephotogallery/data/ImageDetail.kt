package com.obv.spacephotogallery.data

import java.util.*

data class ImageDetail(
    val copyright: String,
    val date: Date,
    val explanation: String,
    val title: String,
    val url: String,
    val hdUrl: String,
    val media_type: String
)
