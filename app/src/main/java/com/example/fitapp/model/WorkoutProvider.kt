package com.example.fitapp.model

import com.example.fitapp.R

class WorkoutProvider {
    companion object{
        val WorkoutList = listOf<Workout>(
            Workout("new","beginer","2 weeks", R.drawable.workout2,"#7DA310"),
            Workout("new2","no beginer","4 weeks", R.drawable.workout, "#20525B"),
            Workout("new3","beginer","1 weeks", R.drawable.workout3, "#213502"),
            Workout("new4","advanced","6 weeks", R.drawable.workout4, "#213502")

        )
    }
}