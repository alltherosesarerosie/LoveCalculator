package com.geektech.lovecalculator

import android.content.Context
import android.content.SharedPreferences
import com.geektech.lovecalculator.remote.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideApi():LoveApi{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/").
        addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun providesPref(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("Calculator.pref", Context.MODE_PRIVATE)
    }
}