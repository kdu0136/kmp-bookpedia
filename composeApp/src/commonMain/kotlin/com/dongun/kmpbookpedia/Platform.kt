package com.dongun.kmpbookpedia

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform