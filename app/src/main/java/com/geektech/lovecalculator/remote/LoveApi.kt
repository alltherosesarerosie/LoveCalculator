package com.geektech.lovecalculator.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {

    @GET("getPercentage")
    fun calculatePerc(
        @Query("fname")firstName:String,
        @Query("sname")secondName:String,
        @Header("X-RapidAPI-Key") key:String="440ccf7feemshe883e1d814406a1p163327jsn74704c2168d0",
        @Header("X-RapidAPI-Host") host:String="love-calculator.p.rapidapi.com"
    ):Call<LoveModel>
}