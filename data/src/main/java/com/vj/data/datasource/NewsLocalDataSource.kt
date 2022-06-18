package com.vj.data.datasource

import com.vj.domain.model.News
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
interface NewsLocalDataSource {
    suspend fun saveNewsToDB(news: News)
    fun getNewsFromDB(): Flow<List<News>>
    suspend fun deleteNewsFromDB(news: News)
}