package com.example.afia.ui.maps

import android.app.PendingIntent.getActivity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.example.afia.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

//infoWindowAdapter(object : GoogleMap.InfoWindowAdapter {
//    // Use default InfoWindow frame
//    override fun getInfoWindow(arg0: Marker?): View? {
//        return null
//    }
//
//    // Defines the contents of the InfoWindow
//    override fun getInfoContents(marker: Marker): View? {
//
//        // Getting view from the layout file info_window_layout
//        val v: View = getActivity().getLayoutInflater().inflate(R.layout.maps_infowindow, null)
//        v.setLayoutParams(LayoutParams((mapFragment.getView().getMeasuredWidth() * .9) as Int, LinearLayout.LayoutParams.WRAP_CONTENT))
//        (v.findViewById(R.id.title) as TextView).setText(marker.getTitle())
//        (v.findViewById(R.id.desc) as TextView).setText(marker.getSnippet())
//        val markerIcon: ImageView = v.findViewById(R.id.imageView5) as ImageView
//        markerIcon.setImageResource(R.mipmap.back_vision_fade)
//        return v
//    }
//})
