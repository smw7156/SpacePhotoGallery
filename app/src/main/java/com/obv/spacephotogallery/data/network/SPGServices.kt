package com.obv.spacephotogallery.data.network

import android.util.Log
import com.obv.spacephotogallery.data.ImageDetail
import retrofit2.Call
import retrofit2.Retrofit;
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.POST

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi).asLenient())
    .baseUrl("https://drive.google.com/a/obvious.in/")
    .build()

interface SpacePhotosServiceApi {
    @GET("file/d/18t-LzVG7bxu-oPxJQZg8P49I9UHcA552/view")
    fun getSpacePhotos(): Call<List<ImageDetail>>
}

object SPGServices {
    val retrofitService: SpacePhotosServiceApi by lazy { retrofit.create(SpacePhotosServiceApi::class.java) }
}