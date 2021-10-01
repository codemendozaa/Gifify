package com.example.gifify.data.model

data class DataResponse (val type:String,
                         val id:String,
                         val url :String,
                         val username :String,
                         val images:DataImagesResponse
                         )

data class DataImagesResponse(
     val original:OriginalResponse
)

data class OriginalResponse(
    val url:String,
    val mp4:String
)


