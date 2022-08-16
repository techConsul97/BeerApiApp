package com.sebqv97.scratchmvvmroomimplementation.domain.beers_repository

import com.sebqv97.scratchmvvmroomimplementation.data.api.BeersAPI
import com.sebqv97.scratchmvvmroomimplementation.data.roomdb.BeerEntity
import com.sebqv97.scratchmvvmroomimplementation.data.roomdb.BeersDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDbBeersDataSource @Inject constructor(
    val beersDAO: BeersDAO

) {

    suspend fun insertBeersIntoDb(beerEntity: BeerEntity) = beersDAO.createBeersInsideDb(beerEntity)

     fun readBeersFromDb() = beersDAO.readBeersFromDb()


}