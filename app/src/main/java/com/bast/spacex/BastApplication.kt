package com.bast.spacex

import android.app.Application
import org.koin.android.ext.android.startKoin
import timber.log.Timber

@Suppress("unused")
class BastApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant( Timber.DebugTree() )
        startKoin(this, listOf(appModule))
    }
}