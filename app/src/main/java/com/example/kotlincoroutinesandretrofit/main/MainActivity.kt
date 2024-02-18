package com.example.kotlincoroutinesandretrofit.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutinesandretrofit.R
import com.example.kotlincoroutinesandretrofit.databinding.ActivityMainBinding
import com.example.kotlincoroutinesandretrofit.model.Posts

class MainActivity : AppCompatActivity(), AdapterPost.PostEvents {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        val data = viewModel.getData()

        data.observe(this) {
            initRecyclerView(it)
        }

    }

    fun initRecyclerView(data: List<Posts>) {
        val myAdapter = AdapterPost(ArrayList(data), this)
        binding.recyclerMain.adapter = myAdapter
        binding.recyclerMain.layoutManager = LinearLayoutManager(
            this, RecyclerView.VERTICAL, false
        )
    }

    override fun onPostClicked(post: Posts) {
        Log.v("LogTest", "data : $post")
    }

}