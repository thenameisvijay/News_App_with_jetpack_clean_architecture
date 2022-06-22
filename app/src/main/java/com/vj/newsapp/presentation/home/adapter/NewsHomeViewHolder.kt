package com.vj.newsapp.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vj.domain.model.Articles
import com.vj.newsapp.databinding.AdapterItemNewsBinding

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
class NewsHomeViewHolder constructor(private val binding: AdapterItemNewsBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bind(article: Articles?) {
        article?.let {
            Picasso.get()
                .load(article.urlToImage)
                .fit()
                .into(binding.newsIv)

            binding.newsTitleTv.text = article.title
//            binding.authorTv.text = article.author
            binding.publishDateTv.text = article.publishedAt
        }
    }
}