package com.sebqv97.scratchmvvmroomimplementation.data.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [BeerEntity::class],
    version = 1,
    exportSchema = false
)

@TypeConverters(BeerTypeConverter::class)
abstract class BeersDatabase : RoomDatabase(){
    abstract fun beersDao() : BeersDAO
}