package com.example.fitapp.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat

import androidx.recyclerview.widget.RecyclerView
import com.example.fitapp.R
import com.example.fitapp.model.Workout
import com.google.android.filament.View
import android.content.Context as Context1
import android.content.Context as context

class WorkoutAdapter(private val WorkoutList:List<Workout>) : RecyclerView.Adapter<WorkoutViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return WorkoutViewHolder(layoutInflater.inflate(R.layout.workout_item, parent, false))
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val item = WorkoutList[position]
        holder.render(item)
        //holder.Context.setImageDrawable(holder.Workoutimgcard.getDrawable(item.card))



    }

    override fun getItemCount(): Int =  WorkoutList.size

}




