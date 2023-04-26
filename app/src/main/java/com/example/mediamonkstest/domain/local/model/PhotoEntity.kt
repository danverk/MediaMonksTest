package com.example.mediamonkstest.domain.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.mediamonkstest.domain.api.model.PhotoResponse
import com.example.mediamonkstest.domain.local.model.PhotoEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class PhotoEntity(

    @PrimaryKey val id: Int,
    @ColumnInfo(name = "album_id") val albumId: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "thumbnail_url") val thumbnailUrl: String,
) {
    companion object {
        const val TABLE_NAME: String = "photo"
    }
}

fun PhotoResponse.toEntity() = PhotoEntity(
    id,
    albumId,
    title,
    url,
    thumbnailUrl
)

