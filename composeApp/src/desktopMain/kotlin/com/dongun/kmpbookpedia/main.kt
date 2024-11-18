package com.dongun.kmpbookpedia

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.dongun.kmpbookpedia.di.initKoin

fun main() {
    initKoin()
    application {
        Window(
            onCloseRequest = ::exitApplication,
            title = "KMP-Bookpedia",
        ) {
            App()
        }
    }
}