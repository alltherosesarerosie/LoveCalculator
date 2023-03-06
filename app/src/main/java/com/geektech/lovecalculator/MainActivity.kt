package com.geektech.lovecalculator

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor(private var pref : SharedPreferences) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navController = findNavController(R.id.fragment_container)

        if (!isUserSeen())
            navController.navigate(R.id.onBoardingFragment)
    }
    private fun isUserSeen(): Boolean {
        return pref.getBoolean("seen.key", false)
    }
}