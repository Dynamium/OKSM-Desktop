@file:Suppress("FunctionName")

package org.dynamium.oksm.ui.components.editor

import androidx.compose.desktop.AppWindowAmbient
import androidx.compose.desktop.SwingPanel
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import org.dynamium.oksm.ui.components.editor.map.SwingWaypoint
import org.dynamium.oksm.ui.components.editor.map.SwingWaypointOverlayPainter
import org.dynamium.oksm.ui.components.editor.sidebar.Sidebar
import org.jxmapviewer.JXMapViewer
import org.jxmapviewer.OSMTileFactoryInfo
import org.jxmapviewer.cache.FileBasedLocalCache
import org.jxmapviewer.input.CenterMapListener
import org.jxmapviewer.input.PanKeyListener
import org.jxmapviewer.input.PanMouseInputListener
import org.jxmapviewer.input.ZoomMouseWheelListenerCursor
import org.jxmapviewer.viewer.DefaultTileFactory
import org.jxmapviewer.viewer.GeoPosition
import org.jxmapviewer.viewer.TileFactoryInfo
import java.awt.Component
import java.awt.Dimension
import java.io.File
import java.util.*
import javax.swing.BoxLayout
import javax.swing.JPanel
import javax.swing.event.MouseInputListener
















@Composable
fun Editor() {

    val windowWidth = AppWindowAmbient.current.width

    val windowHeight = AppWindowAmbient.current.height
    Surface(
        modifier = Modifier,
        color = Color.White
    ) {
        Column {
            Row(
                modifier = Modifier
                    .height((windowHeight - 128).dp)
            ) {
                // Editor
                Column(
                    modifier = Modifier
                        .height((windowHeight - 128).dp)
                        .width((windowWidth - 384).dp),
                ) {
                    SwingPanel(
                        component = swingBox(windowWidth, windowHeight)
                    )
                }

                // Sidebar
                Sidebar()
            }

            BottomStatusBar()
        }
    }
}

fun swingBox(windowWidth: Int, windowHeight: Int): Component {

    val box = JPanel()
    box.layout = BoxLayout(box, BoxLayout.Y_AXIS)

    box.preferredSize = Dimension((windowWidth - 384), (windowHeight - 128))
    val mapViewer = JXMapViewer()

    // Create a TileFactoryInfo for OpenStreetMap
    val info: TileFactoryInfo = OSMTileFactoryInfo()
    val tileFactory = DefaultTileFactory(info)
    mapViewer.tileFactory = tileFactory

    val cacheDir = File(System.getProperty("user.home") + File.separator + ".oksm" + File.separator + "tilecache")
    tileFactory.setLocalCache(FileBasedLocalCache(cacheDir, false))

    // Use 8 threads in parallel to load the tiles
    tileFactory.setThreadPoolSize(8)

    // Set the focus
    val frankfurt = GeoPosition(50, 7, 0, 8, 41, 0)
    val wiesbaden = GeoPosition(50, 5, 0, 8, 14, 0)
    val mainz = GeoPosition(50, 0, 0, 8, 16, 0)
    val darmstadt = GeoPosition(49, 52, 0, 8, 39, 0)
    val offenbach = GeoPosition(50, 6, 0, 8, 46, 0)

    // Add interactions
    val mia: MouseInputListener = PanMouseInputListener(mapViewer)
    mapViewer.addMouseListener(mia)
    mapViewer.addMouseMotionListener(mia)

    mapViewer.addMouseListener(CenterMapListener(mapViewer))

    mapViewer.addMouseWheelListener(ZoomMouseWheelListenerCursor(mapViewer))

    mapViewer.addKeyListener(PanKeyListener(mapViewer))

    mapViewer.zoom = 7
    mapViewer.addressLocation = frankfurt

    val waypoints: Set<SwingWaypoint> = HashSet(
        listOf(
            SwingWaypoint("Frankfurt", frankfurt),
            SwingWaypoint("Wiesbaden", wiesbaden),
            SwingWaypoint("Mainz", mainz),
            SwingWaypoint("Darmstadt", darmstadt),
            SwingWaypoint("Offenbach", offenbach)
        )
    )

    val swingWaypointPainter = SwingWaypointOverlayPainter()
    swingWaypointPainter.setWaypoints(waypoints)
    mapViewer.overlayPainter = swingWaypointPainter

    // Add the JButtons to the map viewer

    // Add the JButtons to the map viewer
    for (w in waypoints) {
        mapViewer.add(w.button)
    }

    mapViewer.addPropertyChangeListener(
        "zoom"
    ) {
        if (mapViewer.zoom >= 17) {
            mapViewer.zoom = 16
        }
    }


    box.add(mapViewer)

    return box
}
