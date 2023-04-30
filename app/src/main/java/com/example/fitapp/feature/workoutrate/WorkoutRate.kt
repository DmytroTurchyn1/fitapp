package com.example.fitapp.feature.workoutrate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.fitapp.R
import com.example.fitapp.feature.workouts.workoutbeg.WorkoutBegPresenter

class WorkoutRate : AppCompatActivity(), WorkoutRateView {
    private lateinit var presenter: WorkoutRatePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_rate)
        val tvActivityname= findViewById<TextView>(R.id.tvActivityname)
        val btnFinish = findViewById<Button>(R.id.btnFinish)
        tvActivityname.text = intent.getStringExtra("Workoutname")
    }

    override fun OnFinishButtonClick() {

    }
}