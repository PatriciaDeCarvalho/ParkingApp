package com.example.data.repositories.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.data.repositories.room.entities.ReservationRoom
import com.example.domain.model.Lot
import com.example.domain.model.Reservation

@Dao
interface ReservationDao {

    @Query("SELECT * FROM Reservation")
    fun getReservations(): List<ReservationRoom>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addReservation(addReservation: ReservationRoom)

    @Delete
    fun deleteReservation(deleteReseervation: ReservationRoom)

}



