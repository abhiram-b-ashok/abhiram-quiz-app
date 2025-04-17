package com.example.myquizapp.playquiz

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myquizapp.databinding.RecyclerResultBinding

class ResultsAdapter( private val resultList: ArrayList<ResultList> ) :RecyclerView.Adapter<ResultsAdapter.ResultsViewHolder>()
{


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultsViewHolder {
        val binding = RecyclerResultBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ResultsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ResultsViewHolder, position: Int) {
        holder.selected.text = resultList[position].selected
        holder.correct.text = resultList[position].correct
        holder.id.text = resultList[position].id.toString()
    }

    override fun getItemCount(): Int {
        Log.d("@@size", "${resultList.size} \n $resultList")
        return resultList.size
    }

    inner class ResultsViewHolder(private val binding: RecyclerResultBinding):RecyclerView.ViewHolder(binding.root) {
        var selected = binding.selectedAns
        val id = binding.questionNo
        val correct = binding.correctAns

    }
}