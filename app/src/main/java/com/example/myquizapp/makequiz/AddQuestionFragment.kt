package com.example.myquizapp.makequiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myquizapp.R
import com.example.myquizapp.databinding.FragmentAddQuestionBinding


class AddQuestionFragment : Fragment() {
   private lateinit var binding: FragmentAddQuestionBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddQuestionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val questionDataBase = QuestionDataBase.getDatabase(requireContext())
//        val newQuestion = Questions(1, "father of our nation?", "nehru", "patel", "bose", "gandhi")
//        questionDataBase.questionsDao().addQuestion(newQuestion)





    }



}