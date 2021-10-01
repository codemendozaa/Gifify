package com.example.gifify.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gifify.GifViewHolder
import com.example.gifify.R
import com.example.gifify.data.model.DataResponse

class GifAdapter(private val data: MutableList<DataResponse>) : RecyclerView.Adapter<GifViewHolder>() {

    interface OnGifItemClickListener{
        fun onItemClick()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return GifViewHolder(layoutInflater.inflate(R.layout.item_grid_character, parent, false))

    }

    override fun getItemCount(): Int = data.size


    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {
        val item = data[position]
        holder.bind(item)

    }


}