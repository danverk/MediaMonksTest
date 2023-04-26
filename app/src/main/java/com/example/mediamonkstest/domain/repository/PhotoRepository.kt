package com.example.mediamonkstest.domain.repository

import com.example.mediamonkstest.domain.local.model.PhotoEntity

interface PhotoRepository {

    suspend fun getPhotosByAlbumId(albumId: Int): List<PhotoEntity>
    suspend fun getPhotoById(photoId: Int): PhotoEntity

}