package com.vj.data.api

import com.vj.data.BuildConfig
import com.vj.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
interface ApiService {

    @GET("v2/top-headlines")
    suspend fun requestTopHeadlines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.API_KEY
    ): Response<NewsResponse>

    @GET("v2/top-headlines")
    suspend fun searchTopHeadlines(
        @Query("country")
        country: String,
        @Query("q")
        query: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.API_KEY
    ): Response<NewsResponse>

}