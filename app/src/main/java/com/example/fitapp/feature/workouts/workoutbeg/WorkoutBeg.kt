package com.example.fitapp.feature.workouts.workoutbeg


import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import android.os.SystemClock
import android.util.Log
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.example.fitapp.R
import com.example.fitapp.feature.workoutrate.WorkoutRate



class WorkoutBeg : AppCompatActivity(), WorkoutBegView {
    private lateinit var presenter: WorkoutBegPresenter
    private var activity = 1
    private lateinit var countDownTimer: CountDownTimer
    private var startTime: Long = 0
    private var running = false
    private lateinit var sharedPreferences: SharedPreferences
    val btnSkip = findViewById<Button>(R.id.btnSkip)
    val tvprogress = findViewById<TextView>(R.id.tvProgress)
    val activityname = findViewById<TextView>(R.id.tvActivityName)
    val progressbar = findViewById<ProgressBar>(R.id.pbProgress)
    val timer = findViewById<TextView>(R.id.tvTime)
    val count = sharedPreferences.getInt("count", 0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout_beg)
        presenter = WorkoutBegPresenter(this)
        btnSkip.setOnClickListener {OnBtnSkipClick()}
        startCountDown(20000,1000)
        sharedPreferences = getSharedPreferences("my_prefs", Context.MODE_PRIVATE)
        startTime = SystemClock.elapsedRealtime()
        running = true
    }
    override fun startCountDown(time:Long,countdown:Long) {
        btnSkip.isVisible =true
        countDownTimer = object: CountDownTimer(time, countdown) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = (millisUntilFinished / 1000) / 60
                val seconds = (millisUntilFinished / 1000) % 60
                timer.text = "$minutes:$seconds"
            }
            override fun onFinish() {
                btnSkip.isVisible =false
            }
        }
        countDownTimer.start()
    }

    override fun OnBtnSkipClick() {
        if (activity !== 10) {
            startCountDown(30000,1000)
            activity++
            progressbar.progress += 10
            progressbar.progress = activity *10
            tvprogress.text = "$activity/10"
            activityname.text = intent.getStringExtra("Workoutname")
            Log.e(TAG, "activity")}
        else if (activity == 10) {

            val intent = Intent(this, WorkoutRate::class.java)
            intent.putExtra("timer", count );
            startActivity(intent)

        }
 }


}