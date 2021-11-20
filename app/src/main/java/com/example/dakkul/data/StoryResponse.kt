package com.example.dakkul.data

import com.google.gson.annotations.SerializedName

data class StoryResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data,
) {
    data class Data(
        @SerializedName("id")
        val id: String = "",
        @SerializedName("title")
        val title: String = "",
        @SerializedName("emoji")
        val emoji: String = "",
        @SerializedName("tags")
        val tags: String = "",
    )
}