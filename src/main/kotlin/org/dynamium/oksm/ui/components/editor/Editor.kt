@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components.editor

import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import org.dynamium.oksm.ui.components.editor.sidebar.Sidebar


@Composable fun Editor() {
    val windowWidth = AppWindowAmbient.current!!.width

    val windowHeight = AppWindowAmbient.current!!.height

    Surface(
        modifier = Modifier,
        color = Color.White
    ) {
        Column {
            Row(
                modifier = Modifier
                    .height((windowHeight - 128).dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Editor
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .width((windowWidth - 256).dp),
                ) {
                    val searchBoxText = remember { mutableStateOf(TextFieldValue("")) }
                }

                // Sidebar
                Sidebar()
            }

            BottomStatusBar()
        }
    }
}