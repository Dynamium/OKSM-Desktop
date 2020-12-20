@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.dynamium.oksm.ui.components.Sidebar
import org.dynamium.oksm.ui.components.editor.Editor
import org.dynamium.oksm.ui.components.editor.TopBar

@Composable
fun MainScreen() {
    Column {
        TopBar()
        Row(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Editor()
            Sidebar()
        }
    }
}
