package com.example.fitapp.feature.workouts.workoutbeg

import android.widget.ProgressBar
import android.widget.TextView
import com.example.fitapp.R
import java.lang.ref.WeakReference

class WorkoutBegPresenter(view: WorkoutBegView) {
    private val viewReference = WeakReference(view)
    private val view
        get() = viewReference.get()

}