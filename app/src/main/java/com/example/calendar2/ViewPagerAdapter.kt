package com.example.calendar2

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.calendar2.fragments.GroupFragment
import com.example.calendar2.fragments.TeacherFragment


class ViewPagerAdapter(fragmentActivity: FragmentActivity) :
    FragmentStateAdapter(fragmentActivity) {
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GroupFragment()
            1->TeacherFragment()
            else -> GroupFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}
