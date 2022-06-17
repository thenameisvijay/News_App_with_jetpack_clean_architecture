package com.vj.data.db

import androidx.room.Database
import androidx.room.TypeConverters
import com.vj.data.model.News

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */

@Database(
    entities = [News::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(SourceConvertor::class)
abstract class NewsDatabase {
    abstract fun getNewsDAO(): NewsDAO
}