package com.example.fitapp.model

import com.example.fitapp.R

class WorkoutProvider {
    companion object{
        val WorkoutList = listOf<Workout>(
            Workout("new","beginer","2 weeks", R.drawable.workout2,"#7DA310"),
            Workout("new2","no beginer","4 weeks", R.drawable.workout, "#20525B"),
            Workout("new3","beginer","1 weeks", R.drawable.workout3, "#213502"),
            Workout("new4","no beginer","3 weeks", R.drawable.workout3, "#54C2CD"),
            Workout("new5","beginer","5 weeks", R.drawable.workout, "#213502"),
            Workout("new6","no beginer","6 weekshjh", R.drawable.workout2, "#7DA310"),

        )
    }
}