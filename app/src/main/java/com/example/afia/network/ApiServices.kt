package com.example.afia.network

import com.example.afia.data.HospitalData
import com.example.afia.data.HospitalsResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "http://192.168.1.100:5000/api/v1/"


private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()


interface ApiServices {

    @GET("hospitals")
    fun getHospitals() : Call<HospitalsResponse>
}

object Api {
    val retrofitServices : ApiServices by lazy { retrofit.create(ApiServices::class.java) }
}


