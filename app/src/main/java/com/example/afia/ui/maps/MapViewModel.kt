package com.example.afia.ui.maps

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.afia.ui.data.HospitalLocation
import com.example.afia.ui.data.MapHospitalsData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

class MapViewModel (application: Application) : AndroidViewModel(application) {

    private val viewModelJop = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJop)

    val hospitals = MutableLiveData<ArrayList<MapHospitalsData>>()

//    val hospitals = ArrayList(listOf(
//            MapHospitalsData('1',"test", HospitalLocation(15.495600, 32.633220)),
//            MapHospitalsData('2',"new", HospitalLocation(15.495939,32.632120)), //15.495939, 32.632120
//            MapHospitalsData('3',"other", HospitalLocation(15.493013,32.629363)) // 15.493013, 32.629363
//    ))
    init {
        hospitals.value = ArrayList(listOf(
            MapHospitalsData('1',"test", HospitalLocation(15.495600, 32.633220)),
            MapHospitalsData('2',"new", HospitalLocation(15.495939,32.632120)), //15.495939, 32.632120
            MapHospitalsData('3',"other", HospitalLocation(15.493013,32.629363)) // 15.493013, 32.629363
    ))
    }
}