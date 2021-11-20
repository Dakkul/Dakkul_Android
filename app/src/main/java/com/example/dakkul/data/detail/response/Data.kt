package com.example.dakkul.data.detail.response

data class Data(
    val description: String,
    val emoji: String,
    val id: Int,
    val imageWanted: String,
    val imageBefore: String,
    val imageAfter: String,
    val tags: List<Tag>,
    val title: String,
    val keyword:String
)