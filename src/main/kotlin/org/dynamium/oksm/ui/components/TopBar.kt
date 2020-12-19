@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.dynamium.oksm.ui.icons.Merge
import org.dynamium.oksm.ui.icons.Save

@Composable
fun TopBar() {
    Surface(
        Modifier
            .fillMaxWidth()
            .height(48.dp)
            .shadow(8.dp)
            .zIndex(1.1F),
        color = Color.White
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Start controls
            Row {
                Image(
                    imageResource("images/topbar/topbar-logo.png"),
                    modifier = Modifier
                        .height(32.dp)
                )
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(Icons.Outlined.Save)
                }

                val areDropdownsExpanded = mutableListOf(
                    remember { mutableStateOf(false) }
                )

                DropdownMenu(
                    expanded = areDropdownsExpanded[0].value,
                    onDismissRequest = { areDropdownsExpanded[0].value = false },
                    toggle = @Composable {
                        IconButton(
                            onClick = {
                                areDropdownsExpanded[0].value = true
                            }
                        ) {
                            Icon(
                                vectorXmlResource("drawables/topbar/ic_path_tools.xml"),
                                modifier = Modifier
                                    .padding(2.dp)
                            )
                        }
                    }
                ) {
                    DropdownMenuItem(
                        enabled = true,
                        onClick = {

                        }
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                modifier = Modifier
                                    .padding(bottom = 3.dp),
                                imageVector = vectorXmlResource("drawables/topbar/ic_path_cut.xml")
                            )
                            Text(
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                text = "Cut the line")
                        }
                    }
                    DropdownMenuItem(
                        enabled = true,
                        onClick = {

                        }
                    ) {
                        Row {
                            Icon(
                                modifier = Modifier
                                    .padding(bottom = 3.dp),
                                imageVector = Icons.Outlined.Merge
                            )
                            Text(
                                modifier = Modifier
                                    .padding(start = 8.dp),
                                text = "Merge two connected lines into one"
                            )
                        }
                    }
                }
            }

            // End controls
            Row {
                IconButton(
                    onClick = {

                    },
                    content = {
                        Icon(Icons.Outlined.Search)
                    }
                )
            }
        }
    }
}
