package com.vj.data.datasource

import com.vj.domain.model.Articles
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
interface NewsLocalDataSource {
    suspend fun saveNewsToDB(articles: Articles)
    fun getNewsFromDB(): Flow<List<Articles>>
    suspend fun deleteNewsFromDB(news: Articles)
}