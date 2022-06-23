package com.vj.newsapp.presentation.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.vj.domain.model.Articles
import com.vj.newsapp.R
import com.vj.newsapp.databinding.AdapterItemNewsBinding

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
class NewsHomeViewHolder constructor(private val binding: AdapterItemNewsBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun bind(article: Articles?, onItemClickListener: ((Articles) -> Unit)?) {
        article?.let {
            Picasso.get()
                .load(article.urlToImage)
                .fit()
                .placeholder(R.drawable.broken_image)
                .into(binding.newsIv)

            binding.newsTitleTv.text = article.title
            binding.publishDateTv.text = article.publishedAt
        }

        binding.root.setOnClickListener {
            onItemClickListener?.let {
                article?.let { item -> it(item) }
            }
        }
    }


}