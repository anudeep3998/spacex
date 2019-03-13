package com.bast.spacex

import org.koin.dsl.module.module

val appModule = module{
    single<HelloRepository> {HelloRepositoryImpl()}

    factory{Presenter(get())}
}