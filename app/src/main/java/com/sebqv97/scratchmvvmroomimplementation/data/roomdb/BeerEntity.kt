package com.sebqv97.scratchmvvmroomimplementation.data.roomdb

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sebqv97.scratchmvvmroomimplementation.data.model.Beers


@Entity(tableName = "beers")
class BeerEntity(val beerEntityModel: Beers) {
    @PrimaryKey(autoGenerate = true)
    var generated_id:Int = 0

}