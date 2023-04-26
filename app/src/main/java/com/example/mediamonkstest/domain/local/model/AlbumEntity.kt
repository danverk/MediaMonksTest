package com.example.mediamonkstest.domain.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mediamonkstest.domain.api.model.AlbumResponse
import com.example.mediamonkstest.domain.local.model.AlbumEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class AlbumEntity(

    @PrimaryKey val id: Int,
    @ColumnInfo(name = "user_id") val userId: Int,
    @ColumnInfo(name = "title") val title: String,
) {
    companion object {
        const val TABLE_NAME: String = "album"
    }
}


fun AlbumResponse.toEntity() = AlbumEntity(
    id,
    userId,
    title
)