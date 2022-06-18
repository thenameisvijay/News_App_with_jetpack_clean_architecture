package com.vj.domain.usecase

import com.vj.domain.model.News
import com.vj.domain.repository.NewsRepository

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(news: News) = newsRepository
}