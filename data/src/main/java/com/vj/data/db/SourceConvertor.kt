package com.vj.data.db

import androidx.room.TypeConverter
import com.vj.data.model.Source

/**
 * Created by Vijay on 17/06/2022.
 * https://github.com/thenameisvijay
 */
class SourceConvertor {

    @TypeConverter
    fun fromSource(source: Source): String = source.name

    @TypeConverter
    fun toSource(name: String): Source = Source(name, name)
}