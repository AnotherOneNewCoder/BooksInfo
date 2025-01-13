package ru.zhogin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform