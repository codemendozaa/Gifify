package com.example.gifify

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.gifify.data.model.DataResponse
import com.example.gifify.databinding.ItemGridFavoriteCharacterBinding

class FavoriteListViewHolder (view: View):RecyclerView.ViewHolder(view){
    private val binding = ItemGridFavoriteCharacterBinding.bind(view)

    fun bind(data: DataResponse){
        Glide.with(this.itemView)
            .asGif()
            .load(data.images.original.url)
            .centerCrop()
            .placeholder(R.drawable.ic_baseline_cloud_download)
            .error(R.drawable.ic_baseline_error)
            .into(binding.characterImage)
        itemView.setOnClickListener {  }
    }



}