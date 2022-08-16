package com.sebqv97.scratchmvvmroomimplementation.domain.beers_repository

import com.sebqv97.scratchmvvmroomimplementation.data.api.BeersAPI
import javax.inject.Inject

class RemoteBeersDataSource @Inject constructor(
    val beersAPI: BeersAPI
) {

    suspend fun getBeersFromAPI() = beersAPI.getBeersFromApi()
}