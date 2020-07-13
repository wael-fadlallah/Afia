package com.example.afia.ui.data


data class MapHospitalsData(
        val id: Char,
        val name: String,
        val location: HospitalLocation
)

data class HospitalLocation(
        val lat : Double,
        val lan : Double
)