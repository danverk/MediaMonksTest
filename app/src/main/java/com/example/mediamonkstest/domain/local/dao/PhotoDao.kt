package com.example.mediamonkstest.domain.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mediamonkstest.domain.local.model.PhotoEntity

@Dao
interface PhotoDao {
    @Insert
    fun insert(vararg photo: PhotoEntity)

    @Query("SELECT * FROM photo")
    fun getAll(): List<PhotoEntity>

    @Query("SELECT * FROM photo WHERE album_id = :albumId")
    fun getAllByAlbumId(albumId: Int): List<PhotoEntity>

    @Query("DELETE FROM photo")
    fun deleteAll()
}