package com.example.myquizapp.makequiz

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Questions(
    @PrimaryKey
    val id:Int =0,
    val questions: String,
    val option1:String,
    val option2:String,
    val option3:String,
    val option4:String,
)
