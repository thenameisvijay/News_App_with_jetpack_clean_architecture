package com.vj.newsapp.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.vj.domain.model.Articles
import com.vj.newsapp.databinding.AdapterItemNewsBinding

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
class NewsHomeAdapter : RecyclerView.Adapter<NewsHomeViewHolder>() {

    private val callback = object : DiffUtil.ItemCallback<Articles>() {
        override fun areItemsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Articles, newItem: Articles): Boolean {
            return oldItem == newItem
        }
    }

    val diffUtils = AsyncListDiffer(this, callback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsHomeViewHolder {
        val binding =
            AdapterItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsHomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsHomeViewHolder, position: Int) {
        val article = diffUtils.currentList[position]
        holder.bind(article)
    }

    override fun getItemCount(): Int {
        return diffUtils.currentList.size
    }
}