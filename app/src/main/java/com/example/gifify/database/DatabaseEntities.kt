package com.example.gifify.database

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "character")
data class CharacterEntity(
    @PrimaryKey @ColumnInfo(name = "character_id") var id: String,
    @ColumnInfo(name = "character_type") var type: String,
    @ColumnInfo(name = "character_url") var url: String?,
    @ColumnInfo(name = "character_username") var username: String,
    @Embedded var images: DataImagesEntity,

)

data class DataImagesEntity(
    val original: OriginalEntity
)

data class OriginalEntity(
    var url: String,
    var mp4: String
)
