package com.example.myquizapp.makequiz

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

@Dao
interface QuestionsDao {
    @Insert
    fun addQuestion(questions: Questions)
    @Delete
    fun deleteQuestion(questions: Questions)
    @Update
    fun updateQuestion(questions: Questions)
}