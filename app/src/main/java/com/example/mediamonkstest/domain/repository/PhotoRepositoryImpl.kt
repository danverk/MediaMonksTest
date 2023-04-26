package com.example.mediamonkstest.domain.repository

import com.example.mediamonkstest.domain.api.RetrofitManager
import com.example.mediamonkstest.domain.local.RoomManager
import com.example.mediamonkstest.domain.local.model.PhotoEntity
import com.example.mediamonkstest.domain.local.model.toEntity

class PhotoRepositoryImpl(
    private val retrofitManager: RetrofitManager,
    private val roomManager: RoomManager
) : PhotoRepository {

    override suspend fun getPhotosByAlbumId(albumId: Int): List<PhotoEntity> {
        val photosResponse = retrofitManager.service.getPhotos().execute()

        val entityList = mutableListOf<PhotoEntity>()
        photosResponse.body()?.let { list ->
            list.forEach { entityList.add(it.toEntity()) }
        }
        roomManager.photoDao.deleteAll()
        roomManager.photoDao.insert(*entityList.toTypedArray())

        return roomManager.photoDao.getAllByAlbumId(albumId)
    }

    override suspend fun getPhotoById(photoId: Int): PhotoEntity {
        return roomManager.photoDao.getById(photoId)
    }
}
