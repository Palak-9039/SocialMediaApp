package com.example.finalproject.data.Model

data class User(
    var name : String = "",
    val userName : String = "",
    val email:String = "",
    val password : String= "",
    val uid : String? = null,
    val imageUrl : String? = "",
    val oneSignalId : String? = null
)
