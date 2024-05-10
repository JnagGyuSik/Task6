package com.example.task6.retrofit

import com.example.task6.data.Data
import com.example.task6.data.ImageDocument
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface NetWorkInterface {
    @Headers("Authorization: KakaoAK d815c8772a8f56b99544ef6ff6a9d4e5")

    @GET("image")
    suspend fun getImageDTO(
        @Query("query") query: String?,
        @Query("sort") sort: String = "recency", //accuracy(정확도순) 또는 recency(최신순)
        @Query("page") page: Int = 1,
        @Query("size") size: Int = 15 //한 페이지에 보여질 문서 수, 1~80 사이의 값,
    ): Data
}