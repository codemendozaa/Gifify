package com.example.gifify


import android.content.Intent
import android.view.View
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gifify.data.model.DataResponse
import com.example.gifify.data.network.CharacterServer
import com.example.gifify.data.network.toCharacterEntity
import com.example.gifify.databinding.ItemGridCharacterBinding
import com.example.gifify.database.CharacterDao
import com.example.gifify.database.CharacterEntity
import io.reactivex.Maybe
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class GifViewHolder(view: View): RecyclerView.ViewHolder(view) {
    private val binding = ItemGridCharacterBinding.bind(view)
    private lateinit var characterDao: CharacterDao
    private var character: CharacterServer? = null
    private val disposable = CompositeDisposable()



    fun bind(data: DataResponse){
        Glide.with(this.itemView)
            .asGif()
            .load(data.images.original.url)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_cloud_download)
            .error(R.drawable.ic_baseline_error)
            .into(binding.ivGif)
        binding.characterFavorite.setOnClickListener { onUpdateFavoriteCharacterStatus() }
        itemView.setOnClickListener { showAlert(data) }
    }

    private fun onUpdateFavoriteCharacterStatus() {

        val characterEntity: CharacterEntity = character!!.toCharacterEntity()
        disposable.add(
            characterDao.getCharacterById(characterEntity.id)
                .isEmpty
                .flatMapMaybe { isEmpty ->
                    if(isEmpty){
                        characterDao.insertCharacter(characterEntity)
                    }else{
                        characterDao.deleteCharacter(characterEntity)
                    }
                    Maybe.just(isEmpty)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe { isFavorite ->
                    updateFavoriteIcon(isFavorite)
                }
        )
    }

    private fun updateFavoriteIcon(isFavorite: Boolean?) {
        binding.characterFavorite.setImageResource(
            if (isFavorite != null && isFavorite) {
                R.drawable.ic_baseline_star
            } else {
                R.drawable.ic_baseline_star_border
            }
        )

    }


    private fun showAlert(data: DataResponse) {
        val url = data.images.original.url
          val intent  = Intent(Intent.ACTION_SEND)
          intent.type = "image/gif"
          intent.putExtra("share this",url)
          val choser = Intent.createChooser(intent,"share using..")
          startActivity(binding.ivGif.context,choser,null)
        //Toast.makeText(binding.ivGif.context, "el name is :${data.username}", Toast.LENGTH_SHORT).show()



    }

}




