package com.example.afia.ui.maps

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.afia.R
import com.example.afia.databinding.ActivityHospitalsSearchBinding
import com.example.afia.data.HospitalLocation
import com.example.afia.data.HospitalData
import com.example.afia.utils.PermissionUtils.isPermissionGranted
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.costom_marker.view.*

class HospitalsSearchActivity : AppCompatActivity(),
        GoogleMap.OnMyLocationButtonClickListener,
        GoogleMap.OnMyLocationClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback,
        OnMapReadyCallback {
    companion object {
        /**
         * Request code for location permission request.
         *
         * @see .onRequestPermissionsResult
         */
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1

        private const val DEFAULT_ZOOM = 15
    }

    private var premissionDenied = false
    private lateinit var mMap: GoogleMap
    private lateinit var mFusedLocationProviderClient:FusedLocationProviderClient

    private lateinit var mData: ArrayList<HospitalData>

    private lateinit var binding : ActivityHospitalsSearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityHospitalsSearchBinding = DataBindingUtil.setContentView(this,R.layout.activity_hospitals_search)
        binding.setLifecycleOwner(this)
        val mapViewModel = ViewModelProviders.of(this).get(MapViewModel::class.java)
        binding.mapViewModel = MapViewModel(application)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
                .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val adapter = MapAdapter(this,object : MapAdapter.OnClickListner{

            override fun hospitl_click(mapLocation: HospitalLocation, itemPosition: Int) {

                Toast.makeText(this@HospitalsSearchActivity,"hospital item click !",Toast.LENGTH_LONG).show()
//                mMap.moveCamera(
//                        CameraUpdateFactory.newLatLngZoom( LatLng(mapLocation.lat,mapLocation.lan) , DEFAULT_ZOOM.toFloat())
//                todo fix the camera
//                )

                (binding.mapHospitalsRecyclerView.layoutManager as LinearLayoutManager ).scrollToPositionWithOffset(itemPosition,10)

            }

        })
        binding.mapHospitalsRecyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        binding.mapHospitalsRecyclerView.adapter = adapter


        mapViewModel.hospitals.observe(this, Observer {
            adapter.submitList(it)
            mData = it
        })
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
//        val sudan = LatLng(12.86, 30.21)
//        mMap.addMarker(MarkerOptions().position(sudan).title("Marker in Sydney"))
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sudan))
        // Construct a FusedLocationProviderClient.
        mFusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return
        }
        mMap.isMyLocationEnabled = true
        mMap.setOnMyLocationButtonClickListener(this)
        mMap.setOnMyLocationClickListener(this)

        enableMyLocation()

        // move the camera to current location
        moveCameraToCurrentLocation()

        // add hospitals location to the map

        // todo move to viewmodel

//        todo fix
//        mData.forEach {
//            val hospital = LatLng(it.location.lat,it.location.lan)
////            mMap.addMarker(MarkerOptions().position(hospital).title(it.name)).showInfoWindow()
//
////            val iconGoogleMap = Icon
//
////            val image: ImageView = findViewById<View>(R.id.main_image) as ImageView
//
//            val tv: LinearLayout = this.layoutInflater.inflate(R.layout.costom_marker, null, false) as LinearLayout
//            tv.title.text = it.name
//            tv.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
//                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED))
//            tv.layout(0, 0, tv.getMeasuredWidth(), tv.getMeasuredHeight())
//
//            tv.setDrawingCacheEnabled(true)
//            tv.buildDrawingCache()
//            val bm = tv.getDrawingCache()
//
//            mMap.addMarker( MarkerOptions().position(hospital).icon( BitmapDescriptorFactory.fromBitmap(bm) ) )
//
//        }

    }

    fun moveCameraToCurrentLocation(){
        try {
            if (!premissionDenied){
                val locationResult = mFusedLocationProviderClient.lastLocation
                locationResult.addOnCompleteListener(this){task ->
                    if(task.isSuccessful){
                        val lastKnwonLocation = task.result
                        if(lastKnwonLocation != null){
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(
                                    LatLng(lastKnwonLocation.latitude,lastKnwonLocation.longitude),
                                    DEFAULT_ZOOM.toFloat()
                            ))
                        }
                    }
                    // todo handel task not successful
                }
            }

        } catch (e: SecurityException) {
            Log.e("Exception: %s", e.message, e)
        }
    }

    private fun enableMyLocation() {
        if (!::mMap.isInitialized) return
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            mMap.isMyLocationEnabled = true
        } else {
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE){
            return
        }
        if(isPermissionGranted(permissions,grantResults,android.Manifest.permission.ACCESS_FINE_LOCATION)){
            // Enable the my location layer if the permission has been granted.
            enableMyLocation()
        }else{
            // Permission was denied. Display an error message
            // Display the missing permission error dialog when the fragments resume.
            premissionDenied = true

        }
    }


    override fun onMyLocationClick(location: Location) {
        Toast.makeText(this, "Current location:\n$location", Toast.LENGTH_LONG).show()
    }

    override fun onMyLocationButtonClick(): Boolean {
        Toast.makeText(this, "MyLocation button clicked", Toast.LENGTH_SHORT).show()

        return false
    }


    override fun onResumeFragments() {
        super.onResumeFragments()
        if (premissionDenied) {
            // Permission was not granted, display error dialog.
            showMissingPermissionError()
            premissionDenied = false
        }
    }

    private fun showMissingPermissionError() {
//        newInstance(true).show(supportFragmentManager, "dialog")
    }
}
