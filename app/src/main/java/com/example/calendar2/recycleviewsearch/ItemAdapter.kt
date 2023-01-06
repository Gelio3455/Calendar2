package com.example.calendar2.recycleviewsearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar2.R
import com.example.calendar2.databinding.ItemItemBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    val itemList = ArrayList<ItemSearch>()

    class ItemHolder(item:View): RecyclerView.ViewHolder(item) {
        val binding = ItemItemBinding.bind(item)


        fun bind(itemsearch:ItemSearch){
            binding.itemText.text=itemsearch.title

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_item,parent,false)
        return  ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int {
       return itemList.size
    }
        fun  addItem(itemsearch:ItemSearch){
            itemList.add(itemsearch)
            notifyDataSetChanged()
        }
}