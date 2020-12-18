@file:Suppress("FunctionName")

package org.dynamium.oksm

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp

@Composable fun MainScreen() {
    TopBar()
}

@Composable private fun TopBar() {
    Surface(
        Modifier
            .fillMaxWidth()
            .height(48.dp)
            .shadow(8.dp),
        color = Color.White
    ) {
        Row {
            Image(
                imageResource("images/topbar/topbar-logo.png"),
                modifier = Modifier
                    .padding(8.dp)
                    .height(32.dp)
            )
        }
    }
}