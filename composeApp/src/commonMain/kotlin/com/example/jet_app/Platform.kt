package com.example.jet_app

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform