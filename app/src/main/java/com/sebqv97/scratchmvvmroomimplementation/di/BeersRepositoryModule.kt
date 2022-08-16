package com.sebqv97.scratchmvvmroomimplementation.di

import com.sebqv97.scratchmvvmroomimplementation.data.api.BeersAPI
import com.sebqv97.scratchmvvmroomimplementation.domain.beers_repository.BeersRepository
import com.sebqv97.scratchmvvmroomimplementation.domain.beers_repository.RemoteBeersDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
class BeersRepositoryModule {

    @Provides
    fun provideBeersApiReference(retrofit: Retrofit):BeersAPI = retrofit.create(BeersAPI::class.java)

//    @Provides
//    fun provideRemoteRepositorySource(api: BeersAPI) = RemoteBeersDataSource(api)
//
//    @Provides
//    fun provideBeersRepositoryReference(remoteBeersDataSource: RemoteBeersDataSource):BeersRepository = BeersRepository(remoteBeersDataSource)
}