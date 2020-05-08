package com.naval.kotlinconcept.interfaces

import com.naval.kotlinconcept.responses.Post
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitService {
    @GET("/posts")
    suspend fun getPosts(): Response<List<Post>>
}