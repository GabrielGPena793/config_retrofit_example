package com.example.retorfitexemples

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun getAll(): Call<List<PostEntity>>
}