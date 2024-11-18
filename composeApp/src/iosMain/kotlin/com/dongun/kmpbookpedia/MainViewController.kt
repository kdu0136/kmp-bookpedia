package com.dongun.kmpbookpedia

import androidx.compose.ui.window.ComposeUIViewController
import com.dongun.kmpbookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}