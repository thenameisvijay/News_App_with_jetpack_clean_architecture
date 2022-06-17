package com.vj.data.db

import androidx.room.*
import com.vj.domain.model.News
import kotlinx.coroutines.flow.Flow

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */

@Dao
interface NewsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: News)

    @Query("SELECT * FROM articles")
    fun getAllNews(): Flow<List<News>>

    @Delete
    suspend fun delete(news: News)
}