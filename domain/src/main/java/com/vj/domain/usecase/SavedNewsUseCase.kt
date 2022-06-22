package com.vj.domain.usecase

import com.vj.domain.model.Articles
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
interface SavedNewsUseCase {
    fun execute(): Flow<List<Articles>>
}