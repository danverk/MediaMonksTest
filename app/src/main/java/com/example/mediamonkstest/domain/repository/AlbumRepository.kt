package com.example.mediamonkstest.domain.repository

import com.example.mediamonkstest.domain.local.model.AlbumEntity

interface AlbumRepository {

   suspend fun getAlbums():List<AlbumEntity>

}