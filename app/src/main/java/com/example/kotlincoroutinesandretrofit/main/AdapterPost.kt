package com.example.kotlincoroutinesandretrofit.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlincoroutinesandretrofit.databinding.ItemPostsBinding
import com.example.kotlincoroutinesandretrofit.model.Posts

class AdapterPost(private val data: ArrayList<Posts>, private val postEvents: PostEvents) :
    RecyclerView.Adapter<AdapterPost.postViewHolder>() {

    inner class postViewHolder(private val binding: ItemPostsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bindData(position: Int) {

            binding.txtTitlePost.text = data[position].title
            binding.txtDesPost.text = data[position].body

            itemView.setOnClickListener {
                postEvents.onPostClicked(data[position])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): postViewHolder {
        val view = ItemPostsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return postViewHolder(view)
    }

    override fun onBindViewHolder(holder: postViewHolder, position: Int) {
        holder.bindData(position)

    }

    override fun getItemCount(): Int {
        return data.size
    }


    interface PostEvents {
        fun onPostClicked(post: Posts)
    }
}
