package com.example.fitapp.feature.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitapp.R
import com.example.fitapp.feature.login.MainPresenter

class HomeActivity : AppCompatActivity(), HomeView {
    private lateinit var presenter: HomePresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter = HomePresenter(this)
    }

}