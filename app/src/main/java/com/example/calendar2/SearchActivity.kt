package com.example.calendar2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calendar2.databinding.ActivitySearchBinding
import com.google.android.material.tabs.TabLayoutMediator

class SearchActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySearchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initial()
    }

    private fun initial() {
        binding.viewPager.adapter = ViewPagerAdapter(this)
        binding.tabLayout.tabIconTint=null
        TabLayoutMediator(binding.tabLayout,binding.viewPager){
                tab, pos ->
            when(pos){
                0 ->{
                    tab.setText("Группы")
                }
                1 ->{
                    tab.setText("Преподаватели")
                }

            }
        }.attach()
    }


}