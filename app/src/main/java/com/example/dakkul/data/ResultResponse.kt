package com.example.dakkul.data

data class ResultResponse(
    val data: List<Data>,
    val message: String,
    val status: Int,
    val success: Boolean
) {
    data class Data(
        val content: String,
        val id: Int,
        val postId: Int
    )
}