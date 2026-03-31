package com.example.finalproject.domain.model

data class User(
    var name : String = "",
    val userName : String = "",
    val email:String = "",
    val password : String= "",
    val uid : String? = null,
    val imageUrl : String? = "",
    val oneSignalId : String? = null
)
