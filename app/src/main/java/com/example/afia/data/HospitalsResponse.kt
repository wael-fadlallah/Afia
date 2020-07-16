package com.example.afia.data

data class HospitalsResponse(
        val success : Boolean ,
        val count : Int ,
        val data : List<HospitalData>
)

data class HospitalData(
        val id: String,
        val name: String,
        val location: HospitalLocation
)

data class HospitalLocation(
        val type : String
//        val coordinates : Ob
//        val lat : Double,
//        val lan : Double
)

//data class coordinates(
//
//)