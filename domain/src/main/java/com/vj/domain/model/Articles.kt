package com.vj.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
@Entity(
    tableName = "articles"
)
data class Articles(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String?,
    val source: Source?,
    val title: String?,
    val url: String?,
    val urlToImage: String?
)
