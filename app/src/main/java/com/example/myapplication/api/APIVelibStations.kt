package com.example.myapplication.api


import retrofit2.http.GET


interface APIVelibStations{
    @GET("/opendata/Velib_Metropole/station_information.json")
    suspend fun getStations():GetVelibStationsResults
}

data class GetVelibStationsResults (val data : Data)
data class Data (val stations: List<VelibStation> )
data class VelibStation  (val station_id: Long, val name: String, val lat:Double ,val lon:Double , val capacity : Int , val stationCode : String )
