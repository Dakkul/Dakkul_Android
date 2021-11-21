package com.example.dakkul.data


import com.example.dakkul.data.remote.DefaultResponse
import retrofit2.Call
import retrofit2.http.*

interface DakkulAPI {

    @POST("/api/{comment}/create")
    suspend fun setPost(
            @Path("comment") comment: String,
            @Query("postId") postId: Int
    ): DefaultResponse

    @GET("/api/post/list")
    fun getStory(
    ) : Call<StoryResponse>

    @POST("/api/post/tagSearch")
    fun getTag(
        @Body body: StoryRequest
    ) : Call<StoryResponse>
}