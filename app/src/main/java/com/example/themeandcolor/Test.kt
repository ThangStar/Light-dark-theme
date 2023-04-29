package com.example.themeandcolor

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.single
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.time.Duration.Companion.seconds

fun main() {
    val arr = listOf(
        User(1, "a"),
        User(2, "a"),
    )
    val arr2 = User(1, "a")
    runBlocking {
        arr.asFlow().collect(){
            println("${it.fullName}")
        }
    }
}

data class User(
    val id: Int,
    val fullName: String,
)