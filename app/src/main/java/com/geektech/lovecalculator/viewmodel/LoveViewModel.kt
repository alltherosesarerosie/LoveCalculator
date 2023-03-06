package com.geektech.lovecalculator.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.geektech.lovecalculator.remote.LoveModel
import com.geektech.lovecalculator.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    fun getLiveLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLove(firstName, secondName)
    }

}