package com.example.finalproject.data.Model

data class CommentData(
    var commentId : String? = "",
    var userId : String? = "",
    var userName: String = "",
    var comment : String? = "",
    var imgUrl : String? = "",
    var timestamp : Long = System.currentTimeMillis()
)
