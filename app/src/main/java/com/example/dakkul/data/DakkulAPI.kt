package com.example.dakkul.data


import com.example.dakkul.data.remote.DefaultResponse
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.Call
import retrofit2.http.GET

interface DakkulAPI {

    @POST("/api/{comment}/create")
    suspend fun setPost(
            @Path("comment") comment: String,
            @Query("postId") postId: Int
    ): DefaultResponse

    @GET("/api/post/list")
    fun getStory(
    ) : Call<StoryResponse>

}