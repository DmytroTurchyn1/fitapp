package com.example.fitapp.fragments

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.graphics.drawable.ColorDrawable

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.TextView

import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fitapp.R
import com.example.fitapp.adapter.WorkoutAdapter
import com.example.fitapp.feature.home.HomeActivity
import com.example.fitapp.feature.login.MainView
import com.example.fitapp.model.WorkoutProvider



private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class WorkoutFragment : Fragment(),WorkoutAdapter.OnItemClickListener, WorkoutFragmentView {

    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }


    private lateinit var popupWindow: PopupWindow

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_workout, container, false)
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            WorkoutFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        InitRecyclerView(view)
    }
    private fun InitRecyclerView(v:View) {
        val recyclerView = v.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = WorkoutAdapter(WorkoutProvider.WorkoutList, this)
    }

    override fun OnItemClick(position: Int) {
        if (position==0){
            ShowPopup()
        }else if (position==1){
            Toast.makeText(context, position.toString(), Toast.LENGTH_LONG).show()
        }else if (position==2){
            Toast.makeText(context, position.toString(), Toast.LENGTH_LONG).show()
        }


    }
    private fun ShowPopup() {
        val popupView = layoutInflater.inflate(R.layout.training1popup, null)
        val closeButton = popupView.findViewById<ImageButton>(R.id.backbutton)
        closeButton.setOnClickListener {
            closePopup()
        }
        popupWindow = PopupWindow(
            popupView,
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT,

            true
        )
        popupWindow.width = 1100
        popupWindow.height = 2100
        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0)
    }
    private fun closePopup() {
        popupWindow.dismiss()
    }

}