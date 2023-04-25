package com.example.mediamonkstest.domain.api

import com.example.mediamonkstest.domain.api.model.AlbumResponse
import retrofit2.Call
import retrofit2.http.GET


interface RetrofitService {

    @GET("albums")
    fun getAlbums(
    ): Call<List<AlbumResponse>>
}