@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components.editor

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomStatusBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clickable {

            }
            .shadow(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 10.dp),
            color = Color.White
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, end = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                LatitudeMarker()
                LongitudeMarker()
            }
        }
    }
}

@Composable
private fun LatitudeMarker() {
    Row(
        modifier = Modifier
            .fillMaxHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            vectorXmlResource("drawables/ic_horizontal_distribute_24px.xml"),
            modifier = Modifier
                .size(18.dp),
        )
        Text(
            text = "latitude location",
            modifier = Modifier
                .padding(start = 14.dp),
        )
    }
}

@Composable
private fun LongitudeMarker() {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(start = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            vectorXmlResource("drawables/ic_vertical_distribute_24px.xml"),
            modifier = Modifier
                .size(18.dp),
        )
        Text(
            text = "longitude location",
            modifier = Modifier
                .padding(start = 14.dp),
        )
    }
}
