package org.dynamium.oksm.ui.components.editor.map

import org.jxmapviewer.viewer.DefaultWaypoint
import org.jxmapviewer.viewer.GeoPosition
import java.awt.Dimension
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JButton
import javax.swing.JOptionPane

class SwingWaypoint(private val text: String, geoPosition: GeoPosition) : DefaultWaypoint(geoPosition) {
    val button = JButton(text.substring(0, 1))

    private inner class SwingWaypointMouseListener : MouseListener {
        override fun mouseClicked(e: MouseEvent) {
            JOptionPane.showMessageDialog(button, "You clicked on $text")
        }

        override fun mousePressed(e: MouseEvent) {

        }
        override fun mouseReleased(e: MouseEvent) {

        }
        override fun mouseEntered(e: MouseEvent) {
            println("entered a waypoint")
        }
        override fun mouseExited(e: MouseEvent) {

        }
    }

    init {
        button.setSize(24, 24)
        button.preferredSize = Dimension(24, 24)
        button.addMouseListener(SwingWaypointMouseListener() as MouseListener)
        button.isVisible = true
    }
}