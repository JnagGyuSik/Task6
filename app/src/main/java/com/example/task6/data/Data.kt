package com.example.task6.data

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("meta")
    val meta: Mata,
    @SerializedName("documents")
    val imageDocument: MutableList<ImageDocument>
)

data class Mata(
    val total_count: Int,
    val pageable_count: Int,
    val is_end: Boolean
)

data class ImageDocument(
    val collection: String, // 컬렉션
    val thumbnail_url: String, //미리보기 이미지 URL
    val image_url: String, // 이미지 URL
    val width: Int, // 이미지 가로 길이
    val height: Int, // 이미지 세로 길이
    val display_sitename: String, //출저
    val doc_url: String, //문서 URL
    val datetime: String //문서 작성시간
)