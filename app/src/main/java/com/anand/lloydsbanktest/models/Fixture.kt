package com.anand.lloydsbanktest.models

data class Fixture(
    val id: Int,
    val sport_id: Int,
    val league_id: Int,
    val season_id: Int,
    val stage_id: Int,
    val venue_id: Int,
    val name: String,
    val starting_at: String,
    val result_info: String,
    val leg: String,
    val length: Int
)

data class FixtureResponse(
    val data: List<Fixture>
)