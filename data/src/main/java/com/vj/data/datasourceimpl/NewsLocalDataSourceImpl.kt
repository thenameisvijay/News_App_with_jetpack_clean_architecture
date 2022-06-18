package com.vj.data.datasourceimpl

import com.vj.data.datasource.NewsLocalDataSource
import com.vj.data.db.NewsDAO
import com.vj.domain.model.News
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
class NewsLocalDataSourceImpl(private val newsDAO: NewsDAO) : NewsLocalDataSource {
    override suspend fun saveNewsToDB(news: News) {
        newsDAO.insert(news)
    }

    override fun getNewsFromDB(): Flow<List<News>> {
        return newsDAO.getAllNews()
    }

    override suspend fun deleteNewsFromDB(news: News) {
        newsDAO.delete(news)
    }
}