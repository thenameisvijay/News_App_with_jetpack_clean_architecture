package com.vj.domain.usecase

import com.vj.domain.model.NewsResponse
import com.vj.domain.repository.NewsRepository
import com.vj.domain.utils.ApiRequestStatus
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
interface SearchNewsUseCase {
    suspend fun execute(country: String, searchQuery: String, page: Int): ApiRequestStatus<NewsResponse>
}