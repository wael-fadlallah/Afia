package com.example.afia.ui.hospitals

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afia.MainActivity
import com.example.afia.data.HospitalData
import com.example.afia.data.HospitalsResponse
import com.example.afia.network.Api
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HospitalsViewModel : ViewModel() {

    val viewModelJop = Job()
    val coroutineScope = CoroutineScope(viewModelJop + Dispatchers.Main)

    private val _hospitals = MutableLiveData<HospitalsResponse>()
    val hospital : LiveData<HospitalsResponse>
        get() = _hospitals

    val hospitalsLodeed = MutableLiveData<Boolean>()

    init {
//        hospitalsLodeed.value = false
        getHospitals()
    }




    fun getHospitals(){
        Api.retrofitServices.getHospitals().enqueue(object : Callback<HospitalsResponse>{
            override fun onFailure(call: Call<HospitalsResponse>, t: Throwable) {
                hospitalsLodeed.value = false
                Log.i(MainActivity.TAG,"Fail to load the data  ${t.message}")
            }

            override fun onResponse(call: Call<HospitalsResponse>, response: Response<HospitalsResponse>) {
                if (response.isSuccessful){
                    _hospitals.value = response.body()
                    Log.i(MainActivity.TAG,"success to load the data  ${response.message()}")
                }
            }
        })
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJop.cancel()
    }

}