package com.example.mediamonkstest.domain.api

import com.example.mediamonkstest.domain.api.model.AlbumResponse
import com.example.mediamonkstest.domain.api.model.PhotoResponse
import retrofit2.Call
import retrofit2.http.GET


interface RetrofitService {

    @GET("albums")
    fun getAlbums(
    ): Call<List<AlbumResponse>>

    @GET("photos")
    fun getPhotos(
    ): Call<List<PhotoResponse>>
}