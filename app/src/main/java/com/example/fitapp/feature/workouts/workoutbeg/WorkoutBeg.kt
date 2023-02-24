package com.example.fitapp.feature.workouts.workoutbeg

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.os.CountDownTimer
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.fitapp.R


class WorkoutBeg : AppCompatActivity(), WorkoutBegView {
    private lateinit var presenter: WorkoutBegPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_beg)
        presenter = WorkoutBegPresenter(this)
        startCountDown()
        activity()
    }


private fun activity(){
    val btnworkoutname = findViewById<TextView>(R.id.btnWorkoutName)
    val tvprogress = findViewById<TextView>(R.id.tvProgress)
    val activityname = findViewById<TextView>(R.id.tvActivityName)
    val progressbar = findViewById<ProgressBar>(R.id.pbProgress)
    progressbar.progress = 10
    tvprogress.text = "1/10"
    activityname.text = "Планка"
    btnworkoutname.text = intent.getStringExtra("Workoutname")
}

    override fun startCountDown() {
        val timer = findViewById<TextView>(R.id.tvTime)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val countDownTimer = object: CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                timer.text = "$minutes:$seconds"
            }

            override fun onFinish() {
                btnNext.isVisible = true
            }
        }
        countDownTimer.start()
    }


}