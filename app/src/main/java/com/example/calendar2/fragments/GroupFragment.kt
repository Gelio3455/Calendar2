package com.example.calendar2.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.calendar2.AppDatabase
import com.example.calendar2.Lesson
import com.example.calendar2.WeeklyActivity
import com.example.calendar2.databinding.FragmentGroupBinding
import com.example.calendar2.recycleviewsearch.ItemAdapter
import kotlinx.coroutines.launch

private var gridLayoutManager: GridLayoutManager? = null


class GroupFragment : Fragment(),ItemAdapter.Listener {
    lateinit var appDb : AppDatabase
    lateinit var binding: FragmentGroupBinding
    private val adapter=ItemAdapter(this)


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
            gridLayoutManager = GridLayoutManager(requireContext(), 2, LinearLayoutManager.VERTICAL, false)
            rcView.layoutManager = gridLayoutManager
            rcView.adapter = adapter
        }
//        lifecycleScope.launch(Dispatchers.IO) {
//        GlobalScope.launch { adapter.addItems(appDb.lessonDao().getAll())}
            lifecycleScope.launch {
                adapter.addItems(appDb.lessonDao().findallgroup())
            }

    }
    override fun onClick(items: Lesson) {

            startActivity(Intent(context, WeeklyActivity::class.java ).apply{
                putExtra("itemGR",items.groupName)
            })

    }


    companion object {


        fun newInstance() =
            GroupFragment()


            }


}
