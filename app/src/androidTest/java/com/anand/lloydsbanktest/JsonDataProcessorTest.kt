package com.anand.lloydsbanktest

import org.json.JSONException
import org.json.JSONObject
import org.junit.Assert
import org.junit.Before
import org.junit.Test


class JsonDataProcessorTest {
    private var jsonData: JSONObject? = null

    @Before
    @Throws(JSONException::class)
    fun setUp() {
        val jsonString = """{
    "data": [
        {
            "id": 216268,
            "sport_id": 1,
            "league_id": 271,
            "season_id": 1273,
            "stage_id": 1086,
            "group_id": null,
            "aggregate_id": null,
            "round_id": 23332,
            "state_id": 5,
            "venue_id": 618,
            "name": "Esbjerg vs OB",
            "starting_at": "2006-03-25 16:00:00",
            "result_info": "Esbjerg won after full-time.",
            "leg": "1/1",
            "details": null,
            "length": 90,
            "placeholder": false,
            "has_odds": false,
            "has_premium_odds": false,
            "starting_at_timestamp": 1143302400
        }
    ],
    "pagination": {
        "count": 25,
        "per_page": 25,
        "current_page": 1,
        "next_page": "https://api.sportmonks.com/v3/football/fixtures?page=2",
        "has_more": true
    },
    "subscription": [
        {
            "meta": [],
            "plans": [
                {
                    "plan": "Football Free Plan",
                    "sport": "Football",
                    "category": "Standard"
                },
                {
                    "plan": "Cricket Free Plan",
                    "sport": "Cricket",
                    "category": "Standard"
                }
            ],
            "add_ons": [],
            "widgets": []
        }
    ],
    "rate_limit": {
        "resets_in_seconds": 3599,
        "remaining": 2999,
        "requested_entity": "Fixture"
    },
    "timezone": "UTC"
}"""
        jsonData = JSONObject(jsonString)
    }

    @Test
    @Throws(JSONException::class)
    fun testJsonDataParsing() {
        // Verify data array size
        val dataArray = jsonData!!.getJSONArray("data")
        Assert.assertEquals(1, dataArray.length().toLong())

        // Verify first data object fields
        val firstMatch = dataArray.getJSONObject(0)
        Assert.assertEquals(216268, firstMatch.getInt("id").toLong())
        Assert.assertEquals(1, firstMatch.getInt("sport_id").toLong())
        Assert.assertEquals(271, firstMatch.getInt("league_id").toLong())
        Assert.assertEquals(1273, firstMatch.getInt("season_id").toLong())
        Assert.assertEquals("Esbjerg vs OB", firstMatch.getString("name"))
        Assert.assertEquals("2006-03-25 16:00:00", firstMatch.getString("starting_at"))
        Assert.assertEquals("Esbjerg won after full-time.", firstMatch.getString("result_info"))
        Assert.assertEquals(1143302400, firstMatch.getLong("starting_at_timestamp"))

        // Verify pagination object fields
        val pagination = jsonData!!.getJSONObject("pagination")
        Assert.assertEquals(25, pagination.getInt("count").toLong())
        Assert.assertEquals(25, pagination.getInt("per_page").toLong())
        Assert.assertEquals(1, pagination.getInt("current_page").toLong())
        Assert.assertTrue(pagination.getBoolean("has_more"))

        // Verify subscription array fields
        val subscriptionArray = jsonData!!.getJSONArray("subscription")
        val firstSubscription = subscriptionArray.getJSONObject(0)
        val plansArray = firstSubscription.getJSONArray("plans")
        Assert.assertEquals(2, plansArray.length().toLong())
        val firstPlan = plansArray.getJSONObject(0)
        Assert.assertEquals("Football Free Plan", firstPlan.getString("plan"))
        Assert.assertEquals("Football", firstPlan.getString("sport"))

        // Verify rate_limit object fields
        val rateLimit = jsonData!!.getJSONObject("rate_limit")
        Assert.assertEquals(3599, rateLimit.getInt("resets_in_seconds").toLong())
        Assert.assertEquals(2999, rateLimit.getInt("remaining").toLong())
        Assert.assertEquals("Fixture", rateLimit.getString("requested_entity"))

        // Verify timezone field
        Assert.assertEquals("UTC", jsonData!!.getString("timezone"))
    }
}
