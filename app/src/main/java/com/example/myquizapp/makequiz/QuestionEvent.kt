package com.example.myquizapp.makequiz

sealed interface QuestionEvent {
     object SaveQuestions:QuestionEvent
     data class SetQuestion(val question:String):QuestionEvent
    data class SetOption1(val option1:String):QuestionEvent
    data class SetOption2(val option2:String):QuestionEvent
    data class SetOption3(val option3:String):QuestionEvent
    data class SetOption4(val option4:String):QuestionEvent
    data class DeleteQuestion(val questions: Questions):QuestionEvent




}