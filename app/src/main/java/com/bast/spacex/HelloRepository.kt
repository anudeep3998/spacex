package com.bast.spacex

interface HelloRepository{
    fun hello(): String
}

class HelloRepositoryImpl() : HelloRepository {
    override fun hello(): String = "Hello Koin"
}