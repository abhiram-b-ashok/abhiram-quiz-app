package com.example.myquizapp.playquiz

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.myquizapp.R
import com.example.myquizapp.databinding.FragmentQuizBinding
import com.example.myquizapp.makequiz.QuestionDataBase
import com.example.myquizapp.makequiz.Questions


class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    var index = 0
    var selectedList: ArrayList<String> = ArrayList()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuizBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataBase = QuestionDataBase.getDatabase(requireContext())
        val list = dataBase.questionsDao().getALLQuestions()
        Log.d("getting_data_", "onViewCreated: $list")
        setData(list)
        var selected = ""
        var validate = 0
        binding.apply {
            option1.setOnClickListener {
                selectedOption(1)
                selected = option1.text.toString()
                validate=1
            }
            option2.setOnClickListener {
                selectedOption(2)
                selected = option2.text.toString()
                validate=2
            }
            option3.setOnClickListener {
                selectedOption(3)
                selected = option3.text.toString()
                validate=3
            }
            option4.setOnClickListener {
                selectedOption(4)
                selected = option4.text.toString()
                validate=4

            }
            questionNumber.text = (index + 1).toString()
            questionOutOf.text = list.size.toString()
            fun validateS(): Boolean {
                if(validate==0)
                {
                    binding.validateSelection.visibility = View.VISIBLE
                    return false
                }
                return true
            }
            nextButton.setOnClickListener {
                if (index < list.size && (index + 1) != list.size && validateS()) {
                    index++
                    setData(list)
                    questionNumber.text = (index + 1).toString()
                    selectedList.add(selected)
                }
                if (index > 0) {
                    binding.prevButton.visibility = View.VISIBLE
                }
                if(index+1 ==list.size)
                {
                    findNavController().navigate(QuizFragmentDirections.quizToResult(selectedList.toTypedArray()))
                }
            }



            prevButton.setOnClickListener {
                if (index > 0) {
                    index--
                    binding.prevButton.visibility = View.VISIBLE
                    setData(list)
                    questionNumber.text = (index + 1).toString()
                }
                if (index == 0) {
                    binding.prevButton.visibility = View.GONE
                }
            }
        }

    }



    private fun setData(list: List<Questions>) {
        binding.apply {
            question.text = list[index].question
            option1.text = list[index].option1
            option2.text = list[index].option2
            option3.text = list[index].option3
            option4.text = list[index].option4
            selectedOption(0)

        }
    }


    private fun selectedOption(position: Int) {
        binding.apply {
            if (position == 1) {
                option1.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.baseline_check_circle_24,
                    0
                )
            } else {
                option1.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.round_adjust_24,
                    0
                )
            }

            if (position == 2) {
                option2.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.baseline_check_circle_24,
                    0
                )
            } else {
                option2.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.round_adjust_24,
                    0
                )
            }
            if (position == 3) {
                option3.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.baseline_check_circle_24,
                    0
                )
            } else {
                option3.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.round_adjust_24,
                    0
                )
            }
            if (position == 4) {
                option4.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.baseline_check_circle_24,
                    0
                )
            } else {
                option4.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.round_adjust_24,
                    0
                )
            }
            if (position == 0) {
                option4.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    0,
                    0,
                    R.drawable.round_adjust_24,
                    0
                )
            }

        }

    }

}