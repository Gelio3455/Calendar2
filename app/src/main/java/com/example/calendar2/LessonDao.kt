package com.example.calendar2

import androidx.room.*

@Dao
interface  LessonDao {
    @Query("SELECT * FROM lesson_table")
    fun getAll(): List<Lesson>

    /* @Query("SELECT * FROM student_table WHERE uid IN (:userIds)")
     fun loadAllByIds(userIds: IntArray): List<Student>*/

    @Query("SELECT * FROM lesson_table WHERE day LIKE :day LIMIT 5 ")
     fun findByday(day: Int): Lesson


     @Query("SELECT DISTINCT Group_name FROM lesson_table")
    suspend fun findallgroup(): List<Lesson>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(lesson: Lesson)

    @Delete
     fun delete(lesson: Lesson)

    @Query("DELETE FROM lesson_table")
     fun deleteAll()
}