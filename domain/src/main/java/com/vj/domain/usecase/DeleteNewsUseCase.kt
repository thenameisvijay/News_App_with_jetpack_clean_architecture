package com.vj.domain.usecase

import com.vj.domain.model.Articles


/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
interface DeleteNewsUseCase {
    suspend fun execute(articles: Articles)
}