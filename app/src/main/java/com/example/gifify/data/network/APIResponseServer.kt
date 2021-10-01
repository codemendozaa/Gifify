package com.example.gifify.data.network

import android.os.Parcelable

import com.example.gifify.data.model.SerializedName
import com.example.gifify.data.network.APIConstants.KEY_ID
import com.example.gifify.data.network.APIConstants.KEY_IMAGES
import com.example.gifify.data.network.APIConstants.KEY_MP4
import com.example.gifify.data.network.APIConstants.KEY_ORIGINAL
import com.example.gifify.data.network.APIConstants.KEY_RESULTS
import com.example.gifify.data.network.APIConstants.KEY_TYPES
import com.example.gifify.data.network.APIConstants.KEY_URL
import com.example.gifify.data.network.APIConstants.KEY_USERNAME



data class CharacterResponseServer(
    @SerializedName(KEY_RESULTS) val results: List<CharacterServer>
)

@Parcelize
data class CharacterServer(
    @SerializedName(KEY_ID) val id: String,
    @SerializedName(KEY_TYPES) val type: String,
    @SerializedName(KEY_URL) val url: String?,
    @SerializedName(KEY_USERNAME) val username: String,
    @SerializedName(KEY_IMAGES) val images: DataImagesResponse

    )

@Parcelize
data class DataImagesResponse(
    @SerializedName(KEY_ORIGINAL) val original:OriginServer

)

annotation class Parcelize

@Parcelize
data class OriginServer(
    @SerializedName(KEY_URL) val url: String,
    @SerializedName(KEY_MP4) val mp4: String
)

