@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components.editor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable fun Sidebar() {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .width(512.dp)
            .shadow(8.dp),
        color = Color.White
    ) {
        Column {
            Text("Test")
        }
    }
}