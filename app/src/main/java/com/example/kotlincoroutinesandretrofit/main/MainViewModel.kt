package com.example.kotlincoroutinesandretrofit.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlincoroutinesandretrofit.model.Posts
import com.example.kotlincoroutinesandretrofit.utils.ApiServiceSingleton
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val getAllData = MutableLiveData<List<Posts>>()

    init {
        GlobalScope.launch {
            val apiService = ApiServiceSingleton.apiService!!
            val data = apiService.getUsers()
            getAllData.postValue(data)
            Log.e("LogTest", "testData : $data")
        }
    }

    fun getData(): LiveData<List<Posts>> {
        return getAllData
    }
}
