package com.example.calendar2.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf

import com.example.calendar2.AppDatabase
import com.example.calendar2.Lesson
import com.example.calendar2.databinding.FragmentDayBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DayFragment : Fragment() {

    lateinit var appDb : AppDatabase
    lateinit var  binding: FragmentDayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        appDb = AppDatabase.getDatabase(requireActivity())
        binding=FragmentDayBinding.inflate(layoutInflater)

        arguments?.getInt(DAY_OF_WEEK)?.let { readData(it) }
        return  binding.root
    }
    fun readData(dayofweek: Int){

        lateinit var lesson: Lesson

        GlobalScope.launch {

            lesson = appDb.lessonDao().findByday(dayofweek)
            Log.d("Robin Data",lesson.toString())
            displayData(lesson)

        }
    }

    private suspend fun displayData(lesson: Lesson){

        withContext(Dispatchers.Main){

            binding.tvFirstName.text = lesson.lessonName
            binding.tvLastName.text = lesson.groupName
            binding.tvRollNo.text = lesson.day.toString()

        }

    }
    companion object {
        const val DAY_OF_WEEK = "Day_of_week"
        fun newInstance(dayofweek:Int) =DayFragment().apply {
            arguments = bundleOf(DAY_OF_WEEK to dayofweek)
        }

    }


}

