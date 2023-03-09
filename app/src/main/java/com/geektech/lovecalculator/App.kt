package com.geektech.lovecalculator

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.geektech.lovecalculator.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext,AppDatabase::class.java, "love_table")
            .allowMainThreadQueries().build()
    }

    companion object{
        lateinit var appDatabase: AppDatabase
    }
}