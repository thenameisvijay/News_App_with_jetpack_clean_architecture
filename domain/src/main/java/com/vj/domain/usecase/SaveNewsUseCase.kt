package com.vj.domain.usecase

import com.vj.domain.model.News

/**
 * Created by Vijay on 18/06/2022.
 * https://github.com/thenameisvijay
 */
interface SaveNewsUseCase {
    suspend fun execute(news: News)
}