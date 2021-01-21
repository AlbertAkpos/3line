package me.alberto.a3line.util

import android.graphics.Color
import java.util.*

object Url {
    const val BASE_URL = "https://jsonplaceholder.typicode.com/"
    const val USERS = "users"
}

const val USER_TABLE = "user_table"

sealed class State {
    object Loading : State()
    data class Error(val message: String) : State()
    object Done : State()
}

fun getRandomColor(): Int {
    val random = Random()
    return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
}