package com.example.myapplication.api


import retrofit2.http.GET


interface APIVelibStations {
    @GET("/opendata/Velib_Metropole/station_information.json")
    suspend fun getStations(): GetVelibStationsResults


    @GET("/opendata/Velib_Metropole/station_status.json")
    suspend fun getStationsDetails(): GetVelibStationsDetails
}

data class GetVelibStationsResults(val data: Data)
data class Data(val stations: List<VelibStation>)
data class VelibStation(
    val station_id: Long,
    val name: String,
    val lat: Double,
    val lon: Double,
    val capacity: Int,
    val stationCode: String,
    )

data class GetVelibStationsDetails(val data: DetailsData)
data class DetailsData(val stations: List<Details>)

data class Details(
    val station_id: Long,
    val stationCode: String,
    val num_bikes_available: Int,
    val num_bikes_available_types: List<BikesTypes>
)
data class BikesTypes(val mechanical: Int, val ebike: Int)

