package com.example.myownnoteapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.example.myownnoteapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        intViews()
    }

    private fun intViews() {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.fragment_containerView) as NavHostFragment

        val navController = navHostFragment.navController
    }
}