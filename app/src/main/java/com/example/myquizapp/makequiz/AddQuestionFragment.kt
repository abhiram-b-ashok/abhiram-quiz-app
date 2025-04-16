package com.example.myquizapp.makequiz

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myquizapp.databinding.FragmentAddQuestionBinding


class AddQuestionFragment : Fragment() {
   private lateinit var binding: FragmentAddQuestionBinding
   private lateinit var dataBase: QuestionDataBase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddQuestionBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataBase = QuestionDataBase.getDatabase(requireContext())


        binding.submit.setOnClickListener {
            val question = binding.addQuestion.text.toString()
            val option1 = binding.option1.text.toString()
            val option2 = binding.option2.text.toString()
            val option3 = binding.option3.text.toString()
            val option4 = binding.option4.text.toString()
            val correctAnswer = binding.correctAnswer.text.toString().toIntOrNull()
                if (question.isBlank() || option1.isBlank() || option2.isBlank() || option3.isBlank() || option4.isBlank() || correctAnswer == null || correctAnswer !in 1..4
                ) {
                    Toast.makeText(requireContext(), "Please fill all fields", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val newQuestion = Questions(
                    question = question,
                    option1 = option1,
                    option2 = option2,
                    option3 = option3,
                    option4 = option4,
                    answer = correctAnswer
                )
               val a = dataBase.questionsDao().addQuestions(newQuestion)
            Log.d("TAG", "onViewCreated: $a")
                Toast.makeText(requireContext(), "Question added successfully", Toast.LENGTH_SHORT).show()

            binding.addQuestion.text.clear()
            binding.option1.text.clear()
            binding.option2.text.clear()
            binding.option3.text.clear()
            binding.option4.text.clear()
            binding.correctAnswer.text.clear()
            }


        }

    }

