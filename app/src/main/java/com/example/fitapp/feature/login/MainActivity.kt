package com.example.fitapp.feature.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fitapp.R
import kotlinx.android.synthetic.main.activity_login.*

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var presenter: MainPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        presenter = MainPresenter(this)

        login_btn.setOnClickListener{ presenter.onLoginBtnClicked()}
    }

    override fun navigateTologin(){

    }

}

