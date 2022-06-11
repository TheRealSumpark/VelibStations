package com.example.myapplication


import androidx.room.*


@Dao
 interface StationsDAO {


    @Query("SELECT * FROM stations")
    fun getAll(): MutableList<Station>

    @Query("SELECT * FROM stations WHERE station_id IN (:station_id)")
    fun loadAllByIds(station_id: IntArray): List<Station>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(vararg stations: Station)

    @Delete
    fun delete(station: Station)


}