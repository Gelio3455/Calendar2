package com.example.calendar2.lessonrcview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.calendar2.Lesson
import com.example.calendar2.R
import com.example.calendar2.databinding.LessonItemBinding
import com.example.calendar2.fragments.DayFragment

class LessonRCAdapter(dayFragment: DayFragment) : RecyclerView.Adapter<LessonRCAdapter.LessonHolder>() {
    val LessonList = ArrayList<Lesson>()
    class LessonHolder(lesson: View): RecyclerView.ViewHolder(lesson) {
        val binding = LessonItemBinding.bind(lesson)
        fun bind(lessonRC: Lesson){
            binding.TVname.text=lessonRC.lessonName
            binding.TVTeacher.text=lessonRC.teachname
            binding.TVgroup.text=lessonRC.groupName
            binding.TVtime.text=lessonRC.time
            binding.TVclassroom.text=lessonRC.roomles




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.lesson_item,parent,false)
        return LessonHolder(view)
    }

    override fun onBindViewHolder(holder: LessonHolder, position: Int) {
        holder.bind(LessonList[position])
    }

    override fun getItemCount(): Int {
        return LessonList.size
    }
    fun  addItem(itemsearch:Lesson){
        LessonList.add(itemsearch)
        notifyDataSetChanged()
    }
    fun  addItems(items:List<Lesson>){
        LessonList.clear()
        LessonList.addAll(items)
        notifyDataSetChanged()
    }


}