package com.unsoed.informatikamobile.data.model

import com.google.gson.annotations.SerializedName

data class SearchResponse(
    @SerializedName(value = "docs")
    val docs: List<BookDoc>
)

data class BookDoc(
    @SerializedName(value = "title")
    val title: String?,
    @SerializedName(value = "author_name")
    val authorName: List<String>?,
    @SerializedName(value = "first_publish_year")
    val firstPublishYear: Int?,
    @SerializedName(value = "cover_i")
    val coverId: Int?
)

