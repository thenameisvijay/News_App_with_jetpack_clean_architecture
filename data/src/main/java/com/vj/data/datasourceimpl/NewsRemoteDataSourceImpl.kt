package com.vj.data.datasourceimpl

import com.vj.data.api.ApiService
import com.vj.data.datasource.NewsRemoteDataSource
import com.vj.domain.model.NewsResponse
import retrofit2.Response

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
class NewsRemoteDataSourceImpl(private val apiService: ApiService) : NewsRemoteDataSource {
    override suspend fun getNewsFromRemote(country: String, page: Int): Response<NewsResponse> {
        return apiService.requestTopHeadlines(country, page)
    }

    override suspend fun searchNewsFromRemote(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<NewsResponse> {
        return apiService.searchTopHeadlines(country, searchQuery, page)
    }
}