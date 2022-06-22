package com.vj.domain.repository


import com.vj.domain.model.Articles
import com.vj.domain.model.NewsResponse
import com.vj.domain.utils.ApiRequestStatus
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
interface NewsRepository {
    suspend fun requestNews(country: String, page: Int): ApiRequestStatus<NewsResponse>
    suspend fun searchNews(
        country: String,
        searchQuery: String,
        page: Int
    ): ApiRequestStatus<NewsResponse>

    suspend fun saveNews(articles: Articles)
    suspend fun deleteNews(articles: Articles)
    fun getSavedNews(): Flow<List<Articles>>
}