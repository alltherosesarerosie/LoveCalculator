package com.geektech.lovecalculator

import com.google.gson.annotations.SerializedName

data class LoveModel (
    @SerializedName("fname")
    var firstName :String,
    @SerializedName("sname")
    var secondName :String,
    var persentage :String,
    var result :String
):java.io.Serializable