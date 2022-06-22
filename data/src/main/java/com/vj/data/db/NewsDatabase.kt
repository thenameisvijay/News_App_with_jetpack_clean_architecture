package com.vj.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.vj.domain.model.Articles

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */

@Database(
    entities = [Articles::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(SourceConvertor::class)
abstract class NewsDatabase: RoomDatabase() {
    abstract fun getNewsDAO(): NewsDAO
}