@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components.editor

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomStatusBar() {
    val latitudeLocation = mutableStateOf("latitude")
    val longitudeLocation = mutableStateOf("longitude")
    val selectedPath = mutableStateOf("selected path")


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(38.dp)
            .clickable {

            }
            .shadow(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 8.dp),
            color = Color.White
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                StatusMarker(
                    icon = vectorXmlResource("drawables/ic_horizontal_distribute_24px.xml"),
                    data = latitudeLocation.value
                )
                StatusMarker(
                    icon = vectorXmlResource("drawables/ic_vertical_distribute_24px.xml"),
                    data = longitudeLocation.value
                )
                StatusMarker(
                    icon = Icons.Outlined.Notifications,
                    data = selectedPath.value
                )
            }
        }
    }
}

@Composable
private fun StatusMarker(modifier: Modifier = Modifier, icon: ImageVector, data: String) {
    Row(
        modifier = modifier
            .fillMaxHeight()
            .padding(start = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            icon,
            modifier = Modifier
                .size(18.dp),
        )
        Text(
            text = data,
            modifier = Modifier
                .padding(start = 14.dp),
        )
    }
}
