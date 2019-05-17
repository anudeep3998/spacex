package com.bast.spacex

import kotlin.reflect.KClass

class ServiceGenerator( private val retrofitGenerator : RetrofitGenerator ) {

    fun <S : Any> createService(service: KClass<S>): S =
        retrofitGenerator.retrofit().create( service.java )

}