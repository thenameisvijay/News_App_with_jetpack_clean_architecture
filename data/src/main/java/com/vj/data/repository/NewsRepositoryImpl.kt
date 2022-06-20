package com.vj.data.repository

import com.vj.data.datasource.NewsLocalDataSource
import com.vj.data.datasource.NewsRemoteDataSource
import com.vj.domain.model.News
import com.vj.domain.model.NewsResponse
import com.vj.domain.repository.NewsRepository
import com.vj.domain.utils.ApiRequestStatus
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
internal class NewsRepositoryImpl @Inject constructor(
    private val newsRemoteDataSource: NewsRemoteDataSource,
//    private val newsLocalDataSource: NewsLocalDataSource
) : NewsRepository {
    override suspend fun requestNews(country: String, page: Int): ApiRequestStatus<NewsResponse> {
        val response = newsRemoteDataSource.getNewsFromRemote(country, page)
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return ApiRequestStatus.Success(result)
            }
        }
        return ApiRequestStatus.Failed(response.message())
    }

    /*override suspend fun searchNews(
        country: String,
        searchQuery: String,
        page: Int
    ): ApiRequestStatus<NewsResponse> {
        val response = newsRemoteDataSource.searchNewsFromRemote(country, searchQuery, page)
        if (response.isSuccessful) {
            response.body()?.let { result ->
                return ApiRequestStatus.Success(result)
            }
        }
        return ApiRequestStatus.Failed(response.message())
    }

    override suspend fun saveNews(news: News) {
        newsLocalDataSource.saveNewsToDB(news)
    }

    override suspend fun deleteNews(news: News) {
        newsLocalDataSource.deleteNewsFromDB(news)
    }

    override fun getSavedNews(): Flow<List<News>> {
        return newsLocalDataSource.getNewsFromDB()
    }*/
}