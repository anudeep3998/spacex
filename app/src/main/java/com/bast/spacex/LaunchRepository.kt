package com.bast.spacex

import androidx.annotation.WorkerThread
import timber.log.Timber

interface LaunchRepository {
    suspend fun allLaunches() : List<LaunchModel>
}

@WorkerThread
class LaunchRepositoryImpl( private val serviceGenerator: ServiceGenerator ): LaunchRepository {
    override suspend fun allLaunches() : List<LaunchModel> {
        return try{
            serviceGenerator.createService( LaunchRemoteService::class ).allLaunchesAsync().await()
        } catch ( e: Exception ) {
            Timber.e( e.toString() )

            ArrayList()
        }
    }
}