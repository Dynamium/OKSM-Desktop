package org.dynamium.oksm

import androidx.compose.desktop.AppManager
import androidx.compose.desktop.Window
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.unit.IntSize
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() = Window(
    size = IntSize(1600, 1000)
) {
    val loadingProgress = mutableStateOf(0.5F)
    SplashScreen(loadingProgress)
    if (loadingProgress.value == 1F) {
        MainScreen()
    }
}
