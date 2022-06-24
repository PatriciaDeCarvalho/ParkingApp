package com.example.data.repositories.room.dao

import androidx.room.*
import com.example.data.repositories.room.entities.ReservationRoom


@Dao
interface ReservationDao {

    @Query("SELECT * FROM Reservation")
    suspend fun getReservations(): List<ReservationRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addReservation(addReservation: ReservationRoom)

    @Delete
    suspend fun deleteReservation(deleteReseervation: ReservationRoom)

    @Query("DELETE FROM Reservation")
    suspend fun deleteReservations()

}



