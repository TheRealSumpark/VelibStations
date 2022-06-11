package com.example.myapplication


import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem

@Entity(tableName = "stations")
 data class Station(@PrimaryKey val station_id: Long,
                    @ColumnInfo val name: String,
                    @ColumnInfo val lat:Double,
                    @ColumnInfo val lon:Double,
                    @ColumnInfo val capacity : Int,
                    @ColumnInfo val stationCode : String,
                    @ColumnInfo var num_bikes_available: Int?=null,
                    @ColumnInfo var mechanical: Int?=null,
                    @ColumnInfo var ebike: Int?=null):ClusterItem
{
    override fun toString(): String {
        return "Station \n" +
                "${station_id}\n " +
                "${name}\n" +
                "${lat}\n" +
                "${lon}\n" +
                "${capacity}\n" +
                "${stationCode}\n"+
                "${num_bikes_available}\n"+
                "${mechanical}\n"
                "${ebike}\n"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Station
        return other.stationCode==this.stationCode
    }

    override fun getPosition(): LatLng  {
        return LatLng(lat,lon)
    }
    override fun getTitle(): String {
        return name
    }

    override fun getSnippet(): String {
      return   "Nombre de véhicules disponibles : ${num_bikes_available}\n" +
                "Mécanique : ${mechanical}\n" +
                "eBike : ${ebike}"
    }

}







