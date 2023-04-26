package com.example.mediamonkstest.domain.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.mediamonkstest.domain.local.model.AlbumEntity

@Dao
interface AlbumDao {
    @Insert
    fun insert(vararg album: AlbumEntity)

    @Query("SELECT * FROM album")
    fun getAll(): List<AlbumEntity>

    @Query("DELETE FROM album")
    fun deleteAll()
}