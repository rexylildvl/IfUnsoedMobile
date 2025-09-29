package com.unsoed.informatikamobile.data.network

import com.unsoed.informatikamobile.data.model.SearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenLibraryApi {

    @GET(value = "search.json")
    suspend fun searchBooks(
        @Query(value = "q") query: String,
        @Query(value = "limit") limit: Int
    ): Response<SearchResponse>
}
