package com.example.fizzbuzz.models

import kotlin.random.Random
import kotlin.random.nextInt

data class FizzBuzzNum(var fizzOrBuzzNum : Int = 0) {

    fun genNumber() : Int {
        return Random.nextInt(1..100)

    }
}
