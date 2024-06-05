package com.anand.lloydsbanktest

import com.anand.lloydsbanktest.models.FixtureResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface FixtureService {
    @GET("football/fixtures")
    suspend fun getFixtures(@Query("api_token") apiToken: String): Response<FixtureResponse>
}