package com.example.myapplication
import android.content.Context
import android.graphics.Color
import android.location.GnssAntennaInfo
import androidx.core.content.ContextCompat
import com.example.myapplication.utils.BitmapHelper

import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.*

import com.google.maps.android.clustering.ClusterManager
import com.google.maps.android.clustering.view.DefaultClusterRenderer


class StationRenderer(
    private val context: Context,
    map: GoogleMap,
    clusterManager: ClusterManager<Station>
) : DefaultClusterRenderer<Station>(context, map, clusterManager) {

    /**
     * The icon to use for each cluster item
     */
    private val bicycleIcon: BitmapDescriptor by lazy {
        val color = ContextCompat.getColor(context,
            R.color.purple_200
        )
        BitmapHelper.vectorToBitmap(
            context,
            R.drawable.ic_baseline_directions_bike_24,
            color
        )
    }
    /**
     * Method called before the cluster item (the marker) is rendered.
     * This is where marker options should be set.
     */
    override fun onBeforeClusterItemRendered(
        item: Station,
        markerOptions: MarkerOptions
    ) {

        markerOptions.title(item.name)
            .position(LatLng(item.lat,item.lon))
            .icon(bicycleIcon)
            .snippet("Nombre de véhicules disponibles : ${item.num_bikes_available}\n" +
                    "Mécanique : ${item.mechanical}\n" +
                    "eBike : ${item.ebike}")

    }

    /**
     * Method called right after the cluster item (the marker) is rendered.
     * This is where properties for the Marker object should be set.
     */
    override fun onClusterItemRendered(clusterItem: Station, marker: Marker) {
        marker.tag = clusterItem

    }
}