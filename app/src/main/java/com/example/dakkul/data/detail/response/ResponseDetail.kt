package com.example.dakkul.data.detail.response

data class ResponseDetail(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
)