package com.example.calendar2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.calendar2.databinding.ActivityWeeklyBinding
import com.example.calendar2.fragments.*

class WeeklyActivity : AppCompatActivity() {
    lateinit var binding : ActivityWeeklyBinding
    private lateinit var appDb : AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weekly)
        binding = ActivityWeeklyBinding.inflate(layoutInflater)
        setContentView(binding.root)

//    ФРАГМЕНТЫ
//      Подключение фрагмента это Понеденльник
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frag_holder, DayFragment.newInstance(1))
            .commit()
        binding.mon.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frag_holder, DayFragment.newInstance(1))
                .commit()
        }

//      Подключение фрагмента это Вторник
        binding.tue.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frag_holder, DayFragment.newInstance(2))
                .commit()
        }

//      Подключение фрагмента это Среда
        binding.wen.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frag_holder, DayFragment.newInstance(3))
                .commit()
        }

//      Подключение фрагмента это Четверг
        binding.thes.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frag_holder, DayFragment.newInstance(4))
                .commit()
        }
//      Подключение фрагмента это Пятница
        binding.fri.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frag_holder, DayFragment.newInstance(5))
                .commit()
        }


// CODE КОД
        val statusview = findViewById<TextView>(R.id.weektype)
        val chet = "Четная"
        statusview.text= chet
    }
    fun swapweek(view: View) {
        val statusview = findViewById<TextView>(R.id.weektype)
        val chet = "Четная"
        val nechet = "Нечетная"
        if (statusview.text === nechet) statusview.text= chet  else statusview.text = nechet
    }




}