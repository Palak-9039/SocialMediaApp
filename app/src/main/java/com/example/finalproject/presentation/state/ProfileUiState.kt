package com.example.finalproject.presentation.state

data class ProfileUiState(
    val photoUrl : String? = null,
    val userName : String = "Guest",
    var name :String = "",
    val message : String? = ""
)
