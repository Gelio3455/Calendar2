package com.example.calendar2

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "lesson_table")
data class Lesson (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name = "lesson_name") val lessonName: String?,
    @ColumnInfo(name = "Group_name") val groupName: String?,
    @ColumnInfo(name = "day") val day: Int?,
    @ColumnInfo(name = "Teacher_Name") val teachname: String?,
    @ColumnInfo(name = "time") val time: String?,
    @ColumnInfo(name = "roomles") val roomles: String?,
    @ColumnInfo(name = "typeOfWeek") val typeOfWeek: Int?


    )