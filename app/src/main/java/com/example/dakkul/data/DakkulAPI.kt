package com.example.dakkul.data

import retrofit2.Call
import retrofit2.http.GET

interface DakkulAPI {
    @GET("/api/post/list")
    fun getStory(
    ) : Call<StoryResponse>
}