package com.example.fitapp.feature.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fitapp.R
import com.example.fitapp.feature.login.MainPresenter
import com.example.fitapp.fragments.AccountFragment
import com.example.fitapp.fragments.CalendarFragment
import com.example.fitapp.fragments.WorkoutFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity(), HomeView {
    private lateinit var presenter: HomePresenter
    private var WorkoutFragment = WorkoutFragment()
    private var CalendarFragment = CalendarFragment()
    private var AccountFragment = AccountFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        presenter = HomePresenter(this)
        replace_fragment(WorkoutFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Workout -> replace_fragment(WorkoutFragment)
                R.id.calendar -> replace_fragment(CalendarFragment)
                R.id.account -> replace_fragment(AccountFragment)
            }
            true
        }
    }

    private fun replace_fragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}