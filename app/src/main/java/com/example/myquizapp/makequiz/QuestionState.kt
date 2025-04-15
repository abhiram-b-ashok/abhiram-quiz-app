package com.example.myquizapp.makequiz

data class QuestionState(
    val questions: List<Questions> = emptyList(),
    val question:String = "",
    val option1:String = "",
    val option2:String = "",
    val option3:String = "",
    val option4:String = "",
    val isAddingQuestions: Boolean = false


)
