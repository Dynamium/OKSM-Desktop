@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components.editor

import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.desktop.SwingPanel
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.dynamium.oksm.ui.components.editor.sidebar.Sidebar
import java.awt.Component
import javax.swing.BoxLayout
import javax.swing.JButton
import javax.swing.JPanel


@Composable
fun Editor() {
    val windowWidth = AppWindowAmbient.current!!.width

    val windowHeight = AppWindowAmbient.current!!.height

    Surface(
        modifier = Modifier,
        color = Color.White
    ) {
        Column {
            Row(
                modifier = Modifier
                    .height((windowHeight - 128).dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Editor
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .width((windowWidth - 256).dp),
                ) {
                    SwingPanel(
                        component = swingBox {
                            println("lol")
                        },
                    )
                }

                // Sidebar
                Sidebar()
            }

            BottomStatusBar()
        }
    }
}

fun swingBox(action: (() -> Unit)? = null): Component {
    val box = JPanel()
    box.layout = BoxLayout(box, BoxLayout.Y_AXIS)

    box.add(actionButton("1. Swing Button: decrement", action))
    box.add(actionButton("2. Swing Button: decrement", action))
    box.add(actionButton("3. Swing Button: decrement", action))

    return box
}

fun actionButton(
    text: String,
    action: (() -> Unit)? = null
): JButton {
    val button = JButton(text)
    button.alignmentX = Component.CENTER_ALIGNMENT
    button.addActionListener { action?.invoke() }

    return button
}