package com.example.calendar2.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calendar2.AppDatabase
import com.example.calendar2.databinding.FragmentDayBinding
import com.example.calendar2.databinding.FragmentDayTeacherBinding
import com.example.calendar2.lessonrcview.LessonRCAdapterTeach
import kotlinx.coroutines.launch

private var gridLayoutManager: GridLayoutManager? = null


class DayFragmentTeacher : Fragment() {

    lateinit var appDb : AppDatabase
    lateinit var  binding: FragmentDayTeacherBinding
    private val adapter= LessonRCAdapterTeach(this)


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?
    {
        appDb = AppDatabase.getDatabase(requireActivity())
        binding= FragmentDayTeacherBinding.inflate(layoutInflater)

        val x= 5
        var Day: Int? = 1
        var GRName: String? = null
        var TCName: String? = null
        var TypeOfWeek: Int? = 1


        arguments?.getInt(DAY_OF_WEEK)?.let { Day = it }
        arguments?.getString(GROUP_NAME)?.let { GRName = it }
        arguments?.getString(TEACHER_NAME)?.let { TCName = it }
        arguments?.getInt(TYPE_OF_WEEK)?.let { TypeOfWeek = it }

        when (Day) {
            1 -> binding.tvDay.text = "Понедельник"
            2 -> binding.tvDay.text = "Вторник"
            3 -> binding.tvDay.text = "Среда"
            4 -> binding.tvDay.text = "Четверг"
            5 -> binding.tvDay.text = "Пятница"
        }



//        Toast.makeText(context, "вы передали type ${TypeOfWeek}", Toast.LENGTH_SHORT).show()
//        Toast.makeText(context, "вы передали TCName ${TCName}", Toast.LENGTH_SHORT).show()
        init2(TCName,Day,TypeOfWeek)




//        arguments?.getInt(DAY_OF_WEEK)?.let { readData(it) }
        return  binding.root
    }


    private fun init2(TCName:String?, Dday: Int?, TypeWeek:Int?){
        val apply = binding.apply {
            gridLayoutManager =GridLayoutManager(requireContext(), 1, LinearLayoutManager.VERTICAL, false)
            rcView.layoutManager = gridLayoutManager
            rcView.adapter = adapter
        }

        lifecycleScope.launch {

            adapter.addItems(appDb.lessonDao().findByTeacher(TCName,Dday, TypeWeek))
        }

    }




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
        =DayFragmentTeacher().apply {
            arguments = bundleOf(
                DAY_OF_WEEK to dayofweek,
                GROUP_NAME to groupname,
                TEACHER_NAME to teachername,
                TYPE_OF_WEEK to typeofweek
            )
        }

    }


}