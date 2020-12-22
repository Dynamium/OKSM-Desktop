@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components.editor

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Close
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorXmlResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import org.dynamium.oksm.ui.icons.*

@Composable
fun Topbar() {
    Surface(
        Modifier
            .fillMaxWidth()
            .height(56.dp)
            .shadow(8.dp)
            .zIndex(1.1F),
        color = Color.White
    ) {
        Row(
            Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Start controls
            Row {
                Image(
                    imageResource("images/topbar/topbar-logo.png"),
                    modifier = Modifier
                        .height(32.dp)
                )
                IconButton(
                    modifier = Modifier
                        .padding(end = 16.dp),
                    onClick = {

                    }
                ) {
                    Icon(Icons.Outlined.Save)
                }

                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(Icons.Outlined.Undo)
                }
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(Icons.Outlined.Redo)
                }

            }

            // End controls
            Row {

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
                                text = "Cut the path"
                            )
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
                                text = "Merge two connected paths into one"
                            )
                        }
                    }
                }
                val isSearchBoxOpened = remember { mutableStateOf(false) }

                val searchBoxText = remember { mutableStateOf(TextFieldValue("")) }

                if (isSearchBoxOpened.value) {
                    Row(
                        Modifier
                            .fillMaxHeight(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextField(
                            value = searchBoxText.value,
                            onValueChange = {
                                searchBoxText.value = it
                            },
                            modifier = Modifier
                                .height(48.dp)
                                .padding(start = 16.dp, top = 2.dp)
                                .clip(RoundedCornerShape(8.dp))
                                .border(width = 2.dp, color = Color.Gray, shape = RoundedCornerShape(8.dp)),
                            placeholder = { Text("Search here...") },
                            trailingIcon = {
                                IconButton(
                                    onClick = {
                                        searchBoxText.value = TextFieldValue("")
                                    },
                                    content = {
                                        Icon(
                                            Icons.Outlined.Backspace,
                                            modifier = Modifier
                                                .padding(end = 2.dp)
                                        )
                                    }
                                )
                            },
                            leadingIcon = {
                                Icon(Icons.Outlined.Search)
                            },
                            backgroundColor = Color.White
                        )
                    }
                }

                Crossfade(current = isSearchBoxOpened, animation = tween(1000)) { state ->
                    IconButton(
                        modifier = Modifier
                            .padding(start = if (!state.value) 16.dp else 0.dp),
                        onClick = {
                            isSearchBoxOpened.value = !isSearchBoxOpened.value
                        }
                    ) {
                        Icon(
                            if (state.value) {
                                Icons.Outlined.Close
                            } else {
                                Icons.Outlined.Search
                            }
                        )
                    }
                }
            }
        }
    }
}
