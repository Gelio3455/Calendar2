package com.example.calendar2

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface  LessonDao {
    @Query("SELECT * FROM lesson_table")
     suspend fun getAll():  List<Lesson>



    @Query("SELECT * FROM lesson_table WHERE day LIKE :day LIMIT 5 ")
    suspend fun findByday(day: Int): Lesson

     @Query("SELECT DISTINCT Group_name FROM lesson_table")
     suspend fun findallgroup(): List<Lesson>

    @Query("SELECT DISTINCT Teacher_Name FROM lesson_table")
    suspend fun findallteacher(): List<Lesson>

    @Query("SELECT * FROM lesson_table WHERE Group_name LIKE :a and day LIKE :b and typeOfWeek LIKE :c  or typeOfWeek = 12 ")
    suspend fun findBygrop(a: String?, b: Int?, c: Int?):  List<Lesson>

    @Query("SELECT * FROM lesson_table WHERE Teacher_Name LIKE :a and day LIKE :b and typeOfWeek LIKE :c  or typeOfWeek = 12   ")
    suspend fun findByTeacher(a: String?, b: Int?, c:Int?): List<Lesson>

//    @Query("SELECT * FROM lesson_table WHERE Group_name LIKE :searchQuery ")
//    suspend fun searchgroup(searchQuery: String): Flow<List<Lesson>>
//    @Query("SELECT * FROM lesson_table WHERE Teacher_Name LIKE :searchQuery ")
//    suspend fun searchteacher(searchQuery: String): Flow<List<Lesson>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(lesson: Lesson)

    @Delete
    suspend fun delete(lesson: Lesson)

    @Query("DELETE FROM lesson_table")
    suspend fun deleteAll()
}