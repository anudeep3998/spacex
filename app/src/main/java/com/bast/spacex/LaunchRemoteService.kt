package com.bast.spacex

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface LaunchRemoteService {

    @GET(value = "launches")
    fun allLaunchesAsync() : Deferred<List<LaunchModel>>
}