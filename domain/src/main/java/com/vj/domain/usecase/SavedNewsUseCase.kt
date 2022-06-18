package com.vj.domain.usecase

import com.vj.domain.model.News
import com.vj.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
class SavedNewsUseCase(private val repository: NewsRepository) {
    suspend fun execute(): Flow<List<News>> = repository.getSavedNews()
}