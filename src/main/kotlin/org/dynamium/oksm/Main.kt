package org.dynamium.oksm

import androidx.compose.desktop.Window
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.KeyStroke
import androidx.compose.ui.window.Menu
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.MenuItem
import org.dynamium.oksm.ui.screens.MainScreen
import org.dynamium.oksm.ui.screens.SplashScreen

fun main() {
    Window(
        title = "OKSM",
        size = IntSize(1600, 1000),
        menuBar = MenuBar(
            Menu("File",
                MenuItem("Settings",
                    onClick = {

                    },
                    shortcut = KeyStroke(Key.X))
            )
        )
    ) {
        val loadingProgress = mutableStateOf(0.5F)
        SplashScreen(loadingProgress)
        MainScreen()
    }
}