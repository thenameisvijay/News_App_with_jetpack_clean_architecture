package com.vj.domain.usecase

import com.vj.domain.model.NewsResponse
import com.vj.domain.repository.NewsRepository
import com.vj.domain.utils.ApiRequestStatus
import retrofit2.Response

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
class SearchNewsUseCase(private val repository: NewsRepository) {
    suspend fun execute(country: String, searchQuery: String, page: Int): ApiRequestStatus<NewsResponse> =
        repository.searchNews(country, searchQuery, page)
}