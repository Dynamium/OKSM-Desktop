@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components.editor.sidebar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp

@Composable
fun Inspector() {
    Column(
        modifier = Modifier
            .width(316.dp)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Header
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = "Inspector",
                style = MaterialTheme.typography.h5
            )
        }
        TagsEditor()
    }
}

@Composable
private fun TagsEditor() {
    MaterialTheme {
        Column {
            Surface(
                modifier = Modifier
                    .width((316 - 24).dp)
                    .shadow(8.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Outlined.ArrowDropDown,
                        modifier = Modifier
                            .clip(RoundedCornerShape(4.dp))
                            .clickable { },
                    )
                    Text(
                        text = "Tags",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier
                            .padding(top = 2.dp),
                    )
                }
            }
            Surface(
                modifier = Modifier
                    .height(128.dp)
                    .width((316 - 24).dp)
                    .shadow(4.dp),
            ) {

            }
        }
    }
}
