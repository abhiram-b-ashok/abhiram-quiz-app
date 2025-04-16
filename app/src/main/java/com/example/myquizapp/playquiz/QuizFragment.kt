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
                selectedOption(1)
            }
            option2.setOnClickListener{
                selectedOption(2)
            }
            option3.setOnClickListener{
                selectedOption(3)
            }
            option4.setOnClickListener{
                selectedOption(4)
            }

           nextButton.setOnClickListener{

            }
        }

    }
   private fun selectedOption(position: Int){
        binding.apply {
            if (position==1)
            {
                option1.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_check_circle_24, 0)
            }
            else{
                option1.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.round_adjust_24, 0)
            }

            if (position==2)
            {
                option2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_check_circle_24, 0)
            }
            else{
                option2.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.round_adjust_24, 0)
            }
            if (position==3)
            {
                option3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_check_circle_24, 0)
            }
            else{
                option3.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.round_adjust_24, 0)
            }
            if (position==4)
            {
                option4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.baseline_check_circle_24, 0)
            }
            else{
                option4.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.round_adjust_24, 0)
            }



        }
    }


}