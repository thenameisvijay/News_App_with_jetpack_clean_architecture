package com.vj.domain.usecase

import com.vj.domain.model.Articles
import com.vj.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
internal class SavedNewsUseCaseImpl @Inject constructor(private val repository: NewsRepository) :
    SavedNewsUseCase {
    override fun execute(): Flow<List<Articles>> = repository.getSavedNews()
}
