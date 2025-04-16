package com.example.myquizapp.playquiz

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.myquizapp.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding
    private val myadapter: ResultsAdapter = ResultsAdapter()
    private val args: ResultFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val selectedAns = args.selection.toList()

        val selectedList = arrayListOf(
            ResultList(1, selectedAns[0], "Green"),
            ResultList(2, selectedAns[1], "Delhi"),
            ResultList(3, selectedAns[2], "UP"),
            ResultList(4, selectedAns[3], "Peacock"),
            ResultList(5, selectedAns[4], "Delhi"),
            )

        binding.resultsRecycler.adapter = myadapter.apply {
            resultList = selectedList
            Log.d("@@listCheck", "$resultList ")
            notifyDataSetChanged()
        }
    }


}