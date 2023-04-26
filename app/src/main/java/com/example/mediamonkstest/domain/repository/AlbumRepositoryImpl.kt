package com.example.mediamonkstest.domain.repository

import com.example.mediamonkstest.domain.api.RetrofitManager
import com.example.mediamonkstest.domain.local.RoomManager
import com.example.mediamonkstest.domain.local.model.AlbumEntity
import com.example.mediamonkstest.domain.local.model.toEntity

class AlbumRepositoryImpl(
    private val retrofitManager: RetrofitManager,
    private val roomManager: RoomManager
) : AlbumRepository {

    override suspend fun getAlbums(): List<AlbumEntity> {
        val albumsResponse = retrofitManager.service.getAlbums().execute()

        val entityList = mutableListOf<AlbumEntity>()
        albumsResponse.body()?.let { list ->
            list.forEach { entityList.add(it.toEntity()) }
        }
        roomManager.albumDao.insert(*entityList.toTypedArray())

        return roomManager.albumDao.getAll()
    }
}
