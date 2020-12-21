@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components.editor

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue


@Composable fun Editor() {
    Surface(
        modifier = Modifier
            .fillMaxSize(),
        color = Color.White
    ) {
        Row {
            // Editor
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                val searchBoxText = remember { mutableStateOf(TextFieldValue("")) }
            }

            // Sidebar
            Sidebar()
        }
    }
}