package com.vj.data.datasource

import com.vj.domain.model.NewsResponse
import retrofit2.Response

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
interface NewsRemoteDataSource {
    suspend fun getNewsFromRemote(country: String, page: Int): Response<NewsResponse>
    suspend fun searchNewsFromRemote(
        country: String,
        searchQuery: String,
        page: Int
    ): Response<NewsResponse>
}