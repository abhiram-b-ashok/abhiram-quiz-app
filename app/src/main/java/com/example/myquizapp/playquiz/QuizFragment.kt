package com.example.myquizapp.playquiz

import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myquizapp.R
import com.example.myquizapp.databinding.FragmentQuizBinding


class QuizFragment : Fragment() {
    private lateinit var binding: FragmentQuizBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentQuizBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            option1.setOnClickListener{
                option1.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_check_circle_24, 0)
            }
            option2.setOnClickListener{
                option2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_check_circle_24, 0)
            }
            option3.setOnClickListener{
                option3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_check_circle_24, 0)
            }
            option4.setOnClickListener{
                option4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_check_circle_24, 0)
            }

           nextButton.setOnClickListener{
               if(selectedOption())
               {
                   findNavController()
               }
            }
        }

    }
   private fun selectedOption():Boolean{
        binding.apply {
            var selected = false
            if(option1.isSelected)
            {
                selected = true
            }
            if(option2.isSelected)
            {
                selected = true
            }
            if(option3.isSelected)
            {
                selected = true
            }
            if(option4.isSelected)
            {
                selected = true
            }
            return selected

        }
    }


}