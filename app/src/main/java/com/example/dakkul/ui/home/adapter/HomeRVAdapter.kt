package com.example.dakkul.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dakkul.data.Story
import com.example.dakkul.data.StoryResponse
import com.example.dakkul.databinding.ItemHomeRvBinding

class HomeRVAdapter : RecyclerView.Adapter<HomeRVAdapter.HomeViewViewHolder>() {
    val itemList = mutableListOf<StoryResponse.Data>()

    class HomeViewViewHolder (private val binding : ItemHomeRvBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: StoryResponse.Data) {
            binding.tvStoryContent.text = data.title
            binding.tvTag1.text = "#${data.tags[0].name}"
            binding.tvTag2.text = "#${data.tags[1].name}"
            if (data.tags.size>2) {
                binding.tvTag3.text = "#${data.tags[2].name}"
            } else {
                binding.tvTag3.isInvisible = true
            }
            Glide.with(binding.ivStoryImage.context)
                .load(data.imageBefore)
                .into(binding.ivStoryImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewViewHolder {
        val binding = ItemHomeRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewViewHolder, position: Int) {
        holder.onBind(itemList[position])

        holder.itemView.setOnClickListener{
            itemClickListner.onClick(it,position)
        }
    }

    override fun getItemCount(): Int = itemList.size

    interface ItemClickListener{
        fun onClick(view: View, position: Int)
    }
    //를릭 리스너
    private lateinit var itemClickListner: ItemClickListener
    fun setItemClickListener(itemClickListener: ItemClickListener) {
        this.itemClickListner = itemClickListener
    }
}