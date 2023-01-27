package com.example.fitapp.adapter

import android.app.SearchManager
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

import com.example.fitapp.model.Workout


class WorkoutAdapter(private val WorkoutList:List<Workout>, private val listener: OnItemClickListener) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(com.example.fitapp.R.layout.workout_item, parent, false)
        return WorkoutViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        val currentItem = WorkoutList[position]
        holder.card.setCardBackgroundColor(Color.parseColor(currentItem.card))
        holder.image.setImageResource(currentItem.img)
        holder.Workoutname.text = currentItem.name
        holder.Workoutlevel.text = currentItem.level
        holder.Workoutdescription.text = currentItem.description

    }

    override fun getItemCount() =  WorkoutList.size

    inner class WorkoutViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        val card: CardView = itemView.findViewById(com.example.fitapp.R.id.card)
        val image: ImageView = itemView.findViewById(com.example.fitapp.R.id.imageView)
        val Workoutname: TextView = itemView.findViewById(com.example.fitapp.R.id.coursename)
        val Workoutlevel: TextView = itemView.findViewById(com.example.fitapp.R.id.courselevel)
        val Workoutdescription: TextView = itemView.findViewById(com.example.fitapp.R.id.coursedescription)
        init {
            itemView.setOnClickListener(this)
        }
        override fun onClick(p0: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) { listener.OnItemClick(position)}

        }
    }

    interface OnItemClickListener{
        fun OnItemClick(position: Int)

    }
}






