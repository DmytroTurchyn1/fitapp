package com.example.fitapp.feature.workouts.workoutbeg

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

interface WorkoutBegView {
    fun startCountDown(time:Long,countdown:Long)
    fun OnBtnSkipClick()


}