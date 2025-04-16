package com.example.myquizapp.makequiz

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface QuestionsDao {


    @Insert
    fun addQuestions(questions: List<Questions>)


    @Query("SELECT * FROM QUESTIONS_TABLE")
    fun getALLQuestions(): List<Questions>

}