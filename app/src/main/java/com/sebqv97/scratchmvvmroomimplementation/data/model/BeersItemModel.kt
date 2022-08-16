package com.sebqv97.scratchmvvmroomimplementation.data.model


import com.google.gson.annotations.SerializedName

data class BeersItemModel(

    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,

)