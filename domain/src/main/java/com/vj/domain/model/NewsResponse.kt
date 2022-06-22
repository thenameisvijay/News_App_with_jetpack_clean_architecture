package com.vj.domain.model

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
data class NewsResponse(
    val articles: List<Articles>,
    val status: String,
    val totalResult: Int
)
