package com.example.calendar2.fragments

import android.content.ClipData
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calendar2.AppDatabase
import com.example.calendar2.R
import com.example.calendar2.databinding.FragmentGroupBinding
import com.example.calendar2.recycleviewsearch.ItemAdapter
import com.example.calendar2.recycleviewsearch.ItemSearch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private var gridLayoutManager: GridLayoutManager? = null


class GroupFragment : Fragment() {
    lateinit var appDb : AppDatabase
    lateinit var binding: FragmentGroupBinding
    private val adapter=ItemAdapter()
    private var index = 0


       override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentGroupBinding.inflate(layoutInflater)
        appDb = AppDatabase.getDatabase(requireActivity())

           init()

        return binding.root
    }

    private fun init(){
        val apply = binding.apply {

            gridLayoutManager =
                GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
            rcView.layoutManager = gridLayoutManager
            rcView.adapter = adapter

        }
//        lifecycleScope.launch(Dispatchers.IO) {
//        GlobalScope.launch { adapter.addItems(appDb.lessonDao().getAll())}
            lifecycleScope.launch { adapter.addItems(appDb.lessonDao().findallgroup()) }



    }

    companion object {


        fun newInstance() =
            GroupFragment()


            }
    }
