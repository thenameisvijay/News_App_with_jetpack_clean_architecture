package com.vj.data.datasourceimpl

import com.vj.data.datasource.NewsLocalDataSource
import com.vj.data.db.NewsDAO
import com.vj.domain.model.Articles
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
class NewsLocalDataSourceImpl @Inject constructor(private val newsDAO: NewsDAO) : NewsLocalDataSource {

    override suspend fun saveNewsToDB(articles: Articles) {
        newsDAO.insert(articles)
    }

    override fun getNewsFromDB(): Flow<List<Articles>> {
        return newsDAO.getAllNews()
    }

    override suspend fun deleteNewsFromDB(articles: Articles) {
        newsDAO.delete(articles)
    }
}