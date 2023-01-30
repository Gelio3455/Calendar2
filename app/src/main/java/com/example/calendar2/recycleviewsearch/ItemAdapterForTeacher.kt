package com.example.calendar2.recycleviewsearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar2.Lesson
import com.example.calendar2.R
import com.example.calendar2.databinding.ItemItemBinding

class ItemAdapterForTeacher(val listener: Listener) : RecyclerView.Adapter<ItemAdapterForTeacher.ItemHolder>() {
    val itemList = ArrayList<Lesson>()

    class ItemHolder(item:View): RecyclerView.ViewHolder(item) {
        val binding = ItemItemBinding.bind(item)
        fun bind(itemsearch:Lesson, listener: Listener){
            binding.itemText.text=itemsearch.teachname

            itemView.setOnClickListener{
                listener.onClick(itemsearch)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_item,parent,false)
        return  ItemHolder(view)
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.bind(itemList[position],listener)
    }

    override fun getItemCount(): Int {
       return itemList.size
    }
        fun  addItem(itemsearch:Lesson){
            itemList.add(itemsearch)
            notifyDataSetChanged()
        }
    fun  addItems(items:List<Lesson>){
        itemList.clear()
        itemList.addAll(items)
        notifyDataSetChanged()
    }
    interface Listener{
        fun onClick(items: Lesson)
    }
}