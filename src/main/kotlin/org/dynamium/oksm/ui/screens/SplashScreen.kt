@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.screens

import androidx.compose.desktop.AppManager
import androidx.compose.desktop.Window
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp

@Composable
fun SplashScreen(
    progressState: MutableState<Float>,
    afterLoadAction: @Composable () -> Unit
) {
    if (progressState.value != 1F) {
        Window(
            title = "OKSM is loading...",
            size = IntSize(500, 300),
            undecorated = true
        ) {
            Image(
                imageResource("images/splashscreen/splash_screen_background.png")
            )
            Column {
                Image(
                    imageResource("images/splashscreen/logo.png"),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 24.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Column(
                    Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    LinearProgressIndicator(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = Color(0xFFFF6D6D),
                        progress = progressState.value
                    )
                }
            }
        }
    } else {
        val windows = AppManager.windows
        println(windows)
        windows[0].close()
        afterLoadAction()
    }
}
