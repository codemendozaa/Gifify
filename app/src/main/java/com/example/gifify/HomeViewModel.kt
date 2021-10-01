package com.example.gifify

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gifify.data.model.GifsResponse

class HomeViewModel:ViewModel() {

    //val gifresponse = MutableLiveData<GifsResponse>()


    fun onCreate() {
       /* viewModelScope.launch {
            val result :List<GifModel>? = getGifUseCase()

            if(!result.isNullOrEmpty()){
                gifmodel.postValue(result[0])
            }
        }*/
    }

    fun randomGif(){
     //   val currentGif = GifProvider.random()
      //  gifmodel.postValue(currentGif)
    }


}