package com.example.calendar2.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import com.example.calendar2.AppDatabase
import com.example.calendar2.R
import com.example.calendar2.databinding.ActivityWeeklyBinding

class WeeklyActivityTeacher : AppCompatActivity() {
    lateinit var binding : ActivityWeeklyBinding
    private lateinit var appDb : AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weekly)
        binding = ActivityWeeklyBinding.inflate(layoutInflater)
        setContentView(binding.root)


// Передача данных
       var     GRName  = intent.getStringExtra("itemGR") ?: "lol"
       var     TCName  = intent.getStringExtra("itemTC") ?: "lol"


// ТИП НЕДЕЛИ
        val statusview = findViewById<TextView>(R.id.weektype)
        val chet = "Четная"
        statusview.text= chet

// Передача типа недели, где 1 нечетная 2 четная, 0 дефотное значение

        var statusINT = 2
        binding.swaptwo.setOnClickListener{
            swapweek()
            if (statusview.text === "Четная") statusINT= 2  else statusINT = 1
        }
        binding.swapone.setOnClickListener{
            swapweek()
            if (statusview.text === "Четная") statusINT= 2  else statusINT = 1
        }

//// ФРАГМЕНТЫ
//// Подключение фрагмента это Понеденльник

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frag_holder, DayFragmentTeacher.newInstance(1,GRName,TCName, statusINT))
            .commit()
        binding.mon.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frag_holder, DayFragmentTeacher.newInstance(1,GRName,TCName, statusINT))
                .commit()
        }

//  Подключение фрагмента это Вторник
        binding.tue.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frag_holder, DayFragmentTeacher.newInstance(2,GRName,TCName,statusINT))
                .commit()
        }

// Подключение фрагмента это Среда
        binding.wen.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frag_holder, DayFragmentTeacher.newInstance(3,GRName,TCName,statusINT))
                .commit()
        }

// Подключение фрагмента это Четверг
        binding.thes.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frag_holder, DayFragmentTeacher.newInstance(4,GRName,TCName,statusINT))
                .commit()
        }
//  Подключение фрагмента это Пятница
        binding.fri.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.frag_holder, DayFragmentTeacher.newInstance(5,GRName,TCName,statusINT))
                .commit()
        }



    }

    private fun swapweek() {
        val statusview = findViewById<TextView>(R.id.weektype)
        val chet = "Четная"
        val nechet = "Нечетная"
        if (statusview.text === nechet) statusview.text= chet  else statusview.text = nechet
    }






}