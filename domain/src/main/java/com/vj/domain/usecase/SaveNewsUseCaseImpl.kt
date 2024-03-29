package com.vj.domain.usecase

import com.vj.domain.model.Articles
import com.vj.domain.repository.NewsRepository
import javax.inject.Inject

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
internal class SaveNewsUseCaseImpl @Inject constructor(private val newsRepository: NewsRepository) :
    SaveNewsUseCase {
    override suspend fun execute(articles: Articles) = newsRepository.saveNews(articles)
}
