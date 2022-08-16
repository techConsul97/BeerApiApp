package com.sebqv97.scratchmvvmroomimplementation.domain.beers_repository

import javax.inject.Inject

class BeersRepository @Inject constructor(
    remoteBeersDataSource: RemoteBeersDataSource,
    localBeerDataSource : LocalDbBeersDataSource
)
{
    val remoteAccess = remoteBeersDataSource
    val localAccess = localBeerDataSource
}