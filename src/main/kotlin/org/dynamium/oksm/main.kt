package org.dynamium.oksm

import androidx.compose.desktop.Window
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.IntSize

fun main() {
    Window(
        title = "OKSM",
        size = IntSize(1600, 1000)
    ) {
        val loadingProgress = mutableStateOf(0.5F)
        SplashScreen(loadingProgress)
        MainScreen()
    }
}