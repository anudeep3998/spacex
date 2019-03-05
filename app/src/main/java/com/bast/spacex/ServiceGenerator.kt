package com.bast.spacex

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import kotlin.reflect.KClass

object ServiceGenerator {

    private val logger = HttpLoggingInterceptor()

    init {
        logger.level = HttpLoggingInterceptor.Level.BODY
    }

    fun <S : Any> createService(service: KClass<S>): S {
        val clientBuilder = OkHttpClient.Builder()
            .connectTimeout( 15000, TimeUnit.MILLISECONDS )
            .readTimeout( 40000, TimeUnit.MILLISECONDS )
            .addInterceptor( logger )

        return Retrofit.Builder()
            .client( clientBuilder.build() )
            .addConverterFactory( MoshiConverterFactory.create() )
            .build()
            .create( service.java )
    }

}