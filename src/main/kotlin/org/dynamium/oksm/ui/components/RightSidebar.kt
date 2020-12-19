@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable fun RightSidebar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .shadow(8.dp),
        color = Color.White
    ) {

    }
}