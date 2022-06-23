package com.example.data.repositories.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.repositories.room.entities.LotRoom
import com.example.data.repositories.room.entities.ReservationRoom
import com.example.domain.model.Lot
import com.example.domain.model.Reservation

@Dao
interface LotDao {

    @Query("SELECT * FROM Lot") /*TODO Do not let a blank space between @Query and the method */

    fun getLots(): List<LotRoom>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addLot(addReservation: LotRoom)
}