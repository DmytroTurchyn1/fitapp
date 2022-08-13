package com.example.fitapp.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapp.R
import com.example.fitapp.model.Workout

class WorkoutViewHolder (view: View):RecyclerView.ViewHolder(view) {
    val Workoutname = view.findViewById<TextView>(R.id.coursename)
    val Workoutlevel = view.findViewById<TextView>(R.id.courselevel)
    val Workoutdescription = view.findViewById<TextView>(R.id.coursedescription)
    fun render(Workoutmodel: Workout){
        Workoutname.text=Workoutmodel.name
        Workoutlevel.text=Workoutmodel.level
        Workoutdescription.text=Workoutmodel.description

    }
}