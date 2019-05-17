package com.bast.spacex

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitGeneratorImpl : RetrofitGenerator {
    private val logger = HttpLoggingInterceptor()

    init {
        logger.level = HttpLoggingInterceptor.Level.BODY
    }


    override fun retrofit() : Retrofit {
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout( 15000, TimeUnit.MILLISECONDS )
            .readTimeout( 40000, TimeUnit.MILLISECONDS )
            .addInterceptor(logger)

        return Retrofit.Builder()
            .client( clientBuilder.build() )
            .addConverterFactory( MoshiConverterFactory.create() )
            .addCallAdapterFactory( CoroutineCallAdapterFactory() )
            .baseUrl("https://api.spacexdata.com/v3/")
            .build()
    }
}

interface RetrofitGenerator{
    fun retrofit(): Retrofit
}