package com.example.dakkul.data


import com.example.dakkul.data.detail.response.ResponseDetail
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

    @GET("/api/post/{postId}")
    fun getDetail(
        @Path("postId") postId : Int
    ) : Call<ResponseDetail>

    /*@GET("/api/comment/list/{postId}")
    fun getResult(
        @Path("postId") postId : Int
    ) : Call<ResponseDetail>*/
}