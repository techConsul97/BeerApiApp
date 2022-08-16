package com.sebqv97.scratchmvvmroomimplementation.data.roomdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.google.android.material.circularreveal.CircularRevealHelper
import kotlinx.coroutines.flow.Flow


@Dao
interface BeersDAO {


    @Query("SELECT * FROM  beers order by generated_id DESC")
    fun readBeersFromDb() : Flow<List<BeerEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun createBeersInsideDb(beerEntity: BeerEntity)
}