package com.example.fitapp.feature.workouts.workoutbeg

import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.fitapp.R
import java.lang.ref.WeakReference

class WorkoutBegPresenter(view: WorkoutBegView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()
    fun Activity(progressbar: ProgressBar, tvprogress: TextView, activityname: TextView,btnworkoutname:TextView, value:String,activity:Int) {
        progressbar.progress = activity*10
        tvprogress.text = "$activity/10"
        activityname.text = "Планка"
        btnworkoutname.text = value
    }


}