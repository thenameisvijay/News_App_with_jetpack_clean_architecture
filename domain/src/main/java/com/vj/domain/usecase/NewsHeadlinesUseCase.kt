package com.vj.domain.usecase

import com.vj.domain.model.NewsResponse
import com.vj.domain.repository.NewsRepository
import com.vj.domain.utils.ApiRequestStatus
import retrofit2.Response

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
class NewsHeadlinesUseCase(private val repository: NewsRepository) {
    suspend fun execute(country: String, page: Int): ApiRequestStatus<NewsResponse> =
        repository.requestNews(country, page)
}