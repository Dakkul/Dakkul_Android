package com.example.dakkul.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dakkul.data.Story
import com.example.dakkul.databinding.ItemHomeRvBinding

class HomeRVAdapter : RecyclerView.Adapter<HomeRVAdapter.HomeViewViewHolder>() {
    val itemList = mutableListOf<Story>()

    class HomeViewViewHolder (private val binding : ItemHomeRvBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: Story) {
//            binding.tvProductName.text = data.name
//            binding.tvProductPrice.text = "${data.price.toString()}원"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewViewHolder {
        val binding = ItemHomeRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeViewViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewViewHolder, position: Int) {
        holder.onBind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size
}