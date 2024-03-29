package com.example.calendar2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.calendar2.databinding.ActivityMainBinding
import com.example.calendar2.todo.TimeTableMain
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var appDb : AppDatabase
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        appDb = AppDatabase.getDatabase(this)

        binding.btnWriteData.setOnClickListener {
            writeData()
        }

        binding.btnReadData.setOnClickListener {
            readData()
        }

        binding.btnDeleteAll.setOnClickListener {

            GlobalScope.launch {

                appDb.lessonDao().deleteAll()

            }

        }
        binding.buttonnew.setOnClickListener{
           onClickNewActivity()
        }
        binding.buttontodo.setOnClickListener{
            onClickNewActivity1()
        }

    }

    private fun onClickNewActivity() {
        val intent = Intent(this, SearchActivity::class.java)
        startActivity(intent)
    }
    private fun onClickNewActivity1() {
        val intent = Intent(this, TimeTableMain::class.java)
        startActivity(intent)
    }


    private fun writeData(){

        val lessonName = binding.etFirstName.text.toString()
        val groupName = binding.etLastName.text.toString()
        val day = binding.etRollNo.text.toString()
        val teachname = binding.teachname.text.toString()
        val time = binding.time.text.toString()
        val roomles = binding.roomles.text.toString()
        val typeOfWeek = binding.typeOfWeek.text.toString()

        if(
            lessonName.isNotEmpty() && groupName.isNotEmpty() && day.isNotEmpty()
            && teachname.isNotEmpty()   && time.isNotEmpty()   && roomles.isNotEmpty()
            && typeOfWeek.isNotEmpty()
        )
        {
            val lesson = Lesson(
                null, lessonName, groupName, day.toInt(), teachname, time, roomles, typeOfWeek.toInt()
            )
            GlobalScope.launch(Dispatchers.IO) {

                appDb.lessonDao().insert(lesson)
            }

            binding.etFirstName.text.clear()
            binding.etLastName.text.clear()
            binding.etRollNo.text.clear()
            binding.teachname.text.clear()
            binding.time.text.clear()
            binding.roomles.text.clear()
            binding.typeOfWeek.text.clear()

            Toast.makeText(this@MainActivity,"Successfully written",Toast.LENGTH_SHORT).show()
        }else Toast.makeText(this@MainActivity,"PLease Enter Data",Toast.LENGTH_SHORT).show()

    }

    private fun readData(){

        val day = binding.etRollNoRead.text.toString()

        if (day.isNotEmpty()){

            lateinit var lesson: Lesson

            GlobalScope.launch {

                lesson = appDb.lessonDao().findByday(day.toInt())
                Log.d("Robin Data",lesson.toString())
                displayData(lesson)

            }

        }else Toast.makeText(this@MainActivity,"Please enter the data", Toast.LENGTH_SHORT).show()

    }

    private suspend fun displayData(lesson: Lesson){

        withContext(Dispatchers.Main){

            binding.tvFirstName.text = lesson.lessonName
            binding.tvLastName.text = lesson.groupName
            binding.tvRollNo.text = lesson.day.toString()

        }

    }

}