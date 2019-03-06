package com.bast.spacex

import android.app.Application
import timber.log.Timber

@Suppress("unused")
class BastApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant( Timber.DebugTree() )
    }
}