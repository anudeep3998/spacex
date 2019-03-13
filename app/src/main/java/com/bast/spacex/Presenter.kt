package com.bast.spacex

class Presenter(val repo: HelloRepository) {
    fun hello() = "${repo.hello()} from $this"
}