package com.sebqv97.scratchmvvmroomimplementation.data.api

import com.sebqv97.scratchmvvmroomimplementation.data.model.Beers
import retrofit2.Response
import retrofit2.http.GET

interface BeersAPI {

    @GET(ApiReference.BEERS_ENDPOINT)
    suspend fun getBeersFromApi(): Response<Beers>
}