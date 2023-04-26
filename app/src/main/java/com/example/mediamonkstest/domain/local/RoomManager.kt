package com.example.mediamonkstest.domain.local

import android.content.Context
import androidx.room.Room

class RoomManager(context: Context) {

    private val roomDatabase =
        (Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "mediamonks-test-database"
        ).build())

    val albumDao = roomDatabase.albumDao()
    val photoDao = roomDatabase.photoDao()
}