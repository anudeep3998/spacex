package com.bast.spacex

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LaunchModel( @Json(name = "flight_number") val flightNumber: Int,
                        @Json(name = "mission_name") val missionName: String,
                        @Json(name = "mission_id") val missionId: List<String>,
                        @Json(name = "launch_year") val launchYear: String,
                        @Json(name = "launch_date_utc") val launchDateUrc: String )