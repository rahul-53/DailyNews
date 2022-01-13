package com.rahul.dailynews.model.local

import androidx.room.TypeConverter
import com.rahul.dailynews.model.remote.Source


class Converters {
    @TypeConverter
    fun  fromSource(source: Source):String{
        return source.name
    }

    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name,name)
    }
}