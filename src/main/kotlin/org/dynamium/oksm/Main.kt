package org.dynamium.oksm

import androidx.compose.desktop.AppManager
import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.window.KeyStroke
import androidx.compose.ui.window.Menu
import androidx.compose.ui.window.MenuBar
import androidx.compose.ui.window.MenuItem
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import mu.KotlinLogging
import org.dynamium.oksm.ui.screens.MainScreen
import org.dynamium.oksm.ui.screens.SplashScreen

private val logger = KotlinLogging.logger {}


fun main() {
    AppManager.setEvents(
        onWindowsEmpty = null,
        onAppStart = {
            logger.info { "Launching OKSM..." }
        }
    )
    val loadingProgress = mutableStateOf(0.5F)


    Window(
        title = "OKSM is loading...",
        size = IntSize(500, 300),
        undecorated = true
    ) {
        MaterialTheme {
            SplashScreen(
                progressState = loadingProgress,
                afterLoadAction = {
                    Window(
                        title = "OKSM",
                        size = IntSize(1600, 1000),
                        menuBar = MenuBar(
                            Menu(
                                "File",
                                MenuItem(
                                    "Settings",
                                    onClick = {

                                    },
                                    shortcut = KeyStroke(Key.X)
                                )
                            )
                        )
                    ) {
                        MainScreen()
                    }

                    AppManager.setEvents(
                        onWindowsEmpty = AppManager.defaultActionOnWindowsEmpty
                    )
                }
            )
        }
        GlobalScope.launch {
            while (loadingProgress.value <= 1F) {
                delay(200)
                loadingProgress.value += 0.1f
                logger.info { loadingProgress.value }
            }
            loadingProgress.value = 1F
        }
    }
}