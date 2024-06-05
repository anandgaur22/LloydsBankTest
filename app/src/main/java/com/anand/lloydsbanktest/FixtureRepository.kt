package com.anand.lloydsbanktest

import com.anand.lloydsbanktest.models.Fixture
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FixtureRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.sportmonks.com/v3/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create(FixtureService::class.java)

    suspend fun getFixtures(): List<Fixture>? {
        val response = service.getFixtures("keyEiMaINIuVi3fy3Nz0skrVYS0eVAxfk56Z8YYys56FX6djsd2xqeBzhQd6")
        return if (response.isSuccessful) {
            response.body()?.data
        } else {
            null
        }
    }
}