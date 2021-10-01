package com.example.gifify.data.network

import com.example.gifify.database.CharacterEntity
import com.example.gifify.database.DataImagesEntity
import com.example.gifify.database.OriginalEntity


fun CharacterResponseServer.toCharacterServerList(): List<CharacterServer> = results.map {
    it.run{
        CharacterServer(
            type,
            id,
            url,
            username,
            images,

        )
    }
}

fun CharacterServer.toCharacterEntity() = CharacterEntity(
    type,
    id,
    url,
    username,
    images.toOriginEntity()

)

fun DataImagesResponse.toOriginEntity() = DataImagesEntity(
    original.toLocationEntity()
)

fun OriginServer.toLocationEntity() = OriginalEntity(
    url,
    mp4
)


