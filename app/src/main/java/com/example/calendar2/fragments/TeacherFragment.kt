package com.example.calendar2.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calendar2.AppDatabase
import com.example.calendar2.Lesson
import com.example.calendar2.R
import com.example.calendar2.WeeklyActivity
import com.example.calendar2.databinding.FragmentGroupBinding
import com.example.calendar2.databinding.FragmentTeacherBinding
import com.example.calendar2.recycleviewsearch.ItemAdapterForTeacher
import kotlinx.coroutines.launch

private var gridLayoutManager: GridLayoutManager? = null

class TeacherFragment : Fragment(),ItemAdapterForTeacher.Listener {
    lateinit var appDb : AppDatabase
    private val adapter= ItemAdapterForTeacher(this)
    lateinit var binding: FragmentTeacherBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeacherBinding.inflate(layoutInflater)
        appDb = AppDatabase.getDatabase(requireActivity())
        init()

        return binding.root
    }
    private fun init(){
        val apply = binding.apply {
            gridLayoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
            rcView.layoutManager = gridLayoutManager
            rcView.adapter = adapter
        }
//        lifecycleScope.launch(Dispatchers.IO) {
//        GlobalScope.launch { adapter.addItems(appDb.lessonDao().getAll())}
        lifecycleScope.launch {
            adapter.addItems(appDb.lessonDao().findallteacher())
        }

    }


    companion object {

        fun newInstance() =
            TeacherFragment()
    }

    override fun onClick(items: Lesson) {

        startActivity(Intent(context, WeeklyActivity::class.java ).apply{
            putExtra("itemTC",items.teachname)
        })

    }
}