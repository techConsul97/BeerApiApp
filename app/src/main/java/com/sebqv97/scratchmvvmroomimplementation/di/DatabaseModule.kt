package com.sebqv97.scratchmvvmroomimplementation.di

import android.content.Context
import androidx.room.Room
import com.sebqv97.scratchmvvmroomimplementation.data.roomdb.BeersDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {



    @Provides
    fun provideRoomInstance(
        @ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        BeersDatabase::class.java,
        "BeersDatabase"
        ).build()

    @Provides
    fun provideBeerDao(database: BeersDatabase) = database.beersDao()

}