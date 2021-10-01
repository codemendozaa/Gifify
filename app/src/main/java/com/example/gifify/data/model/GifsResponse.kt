package com.example.gifify.data.model

data class GifsResponse(
    @SerializedName("data") val data: List<DataResponse>,
    @SerializedName("pagination") val pagination:PaginationResponse,
    @SerializedName("meta") val meta:MetaResponse

    )