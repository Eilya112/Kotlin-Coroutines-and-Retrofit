package com.example.kotlincoroutinesandretrofit.utils

import com.example.kotlincoroutinesandretrofit.model.Posts
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getUsers(): List<Posts>

}