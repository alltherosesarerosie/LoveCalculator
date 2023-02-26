package com.geektech.lovecalculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.geektech.lovecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, FirstFragment()).commit()
        }
    }
}