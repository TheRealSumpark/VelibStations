package com.example.myapplication

data class Station (val station_id: Long, val name: String, val lat:Double ,val lon:Double , val capacity : Int , val stationCode : String)
{
    override fun toString(): String {
        return "${station_id}\n " +
                "${name}\n" +
                "${lat}\n" +
                "${lon}\n" +
                "${capacity}\n" +
                "${stationCode}\n"
    }
}
