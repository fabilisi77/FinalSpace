package com.example.finalspace.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.finalspace.R
import com.example.finalspace.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initUi()

    }
    private fun initUi() {
        initNavigation()

    }

    private fun initNavigation() {
        val navController =
            (supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment).navController
        binding.bottomNavView.setupWithNavController(navController)
    }
}