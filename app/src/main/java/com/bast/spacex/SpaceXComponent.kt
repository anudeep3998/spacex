package com.bast.spacex

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module{
    single<RetrofitGenerator> { RetrofitGeneratorImpl() }

    factory { ServiceGenerator(get()) }

    factory { LaunchRepositoryImpl(get()) as LaunchRepository }

    viewModel { MainViewModel(get()) }
}