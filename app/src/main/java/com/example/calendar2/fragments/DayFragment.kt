package com.example.calendar2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.calendar2.AppDatabase
import com.example.calendar2.Lesson
import com.example.calendar2.databinding.FragmentDayBinding
import com.example.calendar2.lessonrcview.LessonRCAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

private var gridLayoutManager: GridLayoutManager? = null


class DayFragment : Fragment() {

    lateinit var appDb : AppDatabase
    lateinit var  binding: FragmentDayBinding
    private val adapter= LessonRCAdapter(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        appDb = AppDatabase.getDatabase(requireActivity())
        binding=FragmentDayBinding.inflate(layoutInflater)

//        init()

//        arguments?.getInt(DAY_OF_WEEK)?.let { readData(it) }
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        val apply = binding.apply {
            gridLayoutManager = GridLayoutManager(requireContext(), 1, LinearLayoutManager.VERTICAL, false)
            rcView.layoutManager = gridLayoutManager
            rcView.adapter = adapter
        }

        lifecycleScope.launch {
            adapter.addItems(appDb.lessonDao().getAll())
//            adapter.addItems(appDb.lessonDao().findBygrop(GROUP_NAME,DAY_OF_WEEK, TYPE_OF_WEEK))
        }

    }

//    fun readData(dayofweek: Int){
//
//        lateinit var lesson: Lesson
//
//        GlobalScope.launch {
//
//            lesson = appDb.lessonDao().findByday(dayofweek)
//            Log.d("Robin Data",lesson.toString())
//            displayData(lesson)
//
//        }
//    }
//
//    private suspend fun displayData(lesson: Lesson){
//
//        withContext(Dispatchers.Main){
//
//            binding.tvFirstName.text = lesson.lessonName
//            binding.tvLastName.text = lesson.groupName
//            binding.tvRollNo.text = lesson.day.toString()
//
//        }
//
//    }

    companion object {
        const val DAY_OF_WEEK = "Day_of_week"
        const val GROUP_NAME = "Group_name"
        const val TEACHER_NAME = "Teacher_name"
        const val TYPE_OF_WEEK = "Type_of_week"
        fun newInstance
        (
            dayofweek:Int,
            groupname:String,
            teachername:String,
            typeofweek: Int
        )
        =DayFragment().apply {
            arguments = bundleOf(
                DAY_OF_WEEK to dayofweek,
                GROUP_NAME  to groupname,
                TEACHER_NAME to teachername,
                TYPE_OF_WEEK to typeofweek
            )
        }

    }


}

