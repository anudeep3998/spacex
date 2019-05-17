package com.bast.spacex

import org.koin.dsl.module

val appModule = module{
    single<RetrofitGenerator> { RetrofitGeneratorImpl( )}

    factory { ServiceGenerator(get()) }
}