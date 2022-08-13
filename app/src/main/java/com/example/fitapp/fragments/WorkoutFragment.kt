package com.example.fitapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fitapp.R
import com.example.fitapp.adapter.WorkoutAdapter
import com.example.fitapp.model.WorkoutProvider
import kotlinx.android.synthetic.main.fragment_workout.*


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class WorkoutFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

    }




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout, container, false)
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

        InitRecyclerView()
    }
    private fun InitRecyclerView() {

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = WorkoutAdapter(WorkoutProvider.WorkoutList)
    }


}