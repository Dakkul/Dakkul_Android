package com.example.dakkul.data.detail.response

data class Data(
    val description: String,
    val emoji: String,
    val id: Int,
    val image_wanted: String,
    val tags: List<Tag>,
    val title: String
)