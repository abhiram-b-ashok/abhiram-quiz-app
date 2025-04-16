package com.example.myquizapp.makequiz

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Questions::class], version = 1)
abstract class QuestionDataBase : RoomDatabase() {
    abstract fun questionsDao(): QuestionsDao

    companion object {
        @Volatile
        private var INSTANCE: QuestionDataBase? = null

        fun getDatabase(context: Context): QuestionDataBase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext, QuestionDataBase::class.java,
                    "question_database"
                ).allowMainThreadQueries()
                    .build()

            }

            return INSTANCE!!
        }
    }

}