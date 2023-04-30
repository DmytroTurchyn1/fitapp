package com.example.fitapp.model

import com.example.fitapp.R

class WorkoutProvider {
    companion object{
        val WorkoutList = listOf<Workout>(
            Workout("new","beginer","2 weeks", R.drawable.workout2,"#7DA310")
        )
    }
}