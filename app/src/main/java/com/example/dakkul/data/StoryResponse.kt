package com.example.dakkul.data

data class StoryResponse(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: List<Data>,
) {
    data class Data(
        val id: Int,
        val title: String,
        val imageBefore: String,
        val tags: List<Tag>
    ) {
        data class Tag(
            val id: Int,
            val name: String
        )
    }
}