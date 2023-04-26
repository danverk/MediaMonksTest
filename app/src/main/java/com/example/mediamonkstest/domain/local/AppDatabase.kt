package com.example.mediamonkstest.domain.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mediamonkstest.domain.local.dao.AlbumDao
import com.example.mediamonkstest.domain.local.dao.PhotoDao
import com.example.mediamonkstest.domain.local.model.AlbumEntity
import com.example.mediamonkstest.domain.local.model.PhotoEntity

@Database(entities = [AlbumEntity::class, PhotoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
    abstract fun photoDao(): PhotoDao
}
