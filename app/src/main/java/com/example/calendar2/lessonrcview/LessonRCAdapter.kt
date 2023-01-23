//package com.example.calendar2.lessonrcview
//
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.calendar2.Lesson
//import com.example.calendar2.databinding.ItemItemBinding
//import com.example.calendar2.databinding.LessonItemBinding
//
//class LessonRCAdapter: RecyclerView.Adapter<LessonRCAdapter.LessonHolder>() {
//    val LessonList = ArrayList<Lesson>()
//    class LessonHolder(lesson: View): RecyclerView.ViewHolder(lesson) {
//        val binding = LessonItemBinding.bind(lesson)
//        fun bind(lessonRC: Lesson){
//            binding.TVname.text=lessonRC.lessonName
//            binding.TVwho.text=lessonRC.groupName
////            binding.TVtime.text=lessonRC.time
////            binding.TVclassroom.text=lessonRC.roomles
//
//
//
//
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LessonHolder {
//        TODO("Not yet implemented")
//    }
//
//    override fun onBindViewHolder(holder: LessonHolder, position: Int) {
//        TODO("Not yet implemented")
//    }
//
//    override fun getItemCount(): Int {
//        TODO("Not yet implemented")
//    }
//
//
//}