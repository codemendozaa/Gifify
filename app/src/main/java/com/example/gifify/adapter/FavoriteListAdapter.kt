package com.example.gifify.adapter


/* class FavoriteListAdapter(
    private val listener: (CharacterEntity) -> Unit
): RecyclerView.Adapter<FavoriteListAdapter.FavoriteListViewHolder>() {

    private val characterList: MutableList<CharacterEntity> = mutableListOf()

    fun updateData(newData: List<CharacterEntity>) {
        characterList.clear()
        characterList.addAll(newData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        FavoriteListViewHolder(
            parent.bindingInflate(R.layout.item_grid_favorite_character, false),
            listener
        )

    override fun getItemCount() = characterList.size

    override fun getItemId(position: Int): Long = characterList[position].id.toLong()

    override fun onBindViewHolder(holder: FavoriteListViewHolder, position: Int) {
        holder.bind(characterList[position])
    }

   class FavoriteListViewHolder(
        private val dataBinding: ItemGridFavoriteCharacterBinding,
        private val listener: (CharacterEntity) -> Unit
    ): RecyclerView.ViewHolder(dataBinding.root) {

        //region Public Methods

        fun bind(item: CharacterEntity){
            dataBinding.character = item
            itemView.character_image.bindImageUrl(
                url = item.image,
                placeholder = R.drawable.ic_camera_alt_black,
                errorPlaceholder = R.drawable.ic_broken_image_black
            )
            itemView.setOnClickListener { listener(item) }
        }

        //endregion
    }
}*/
