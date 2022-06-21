package com.example.domain.repositories

import com.example.domain.model.Reservation
import com.example.domain.util.Result

interface AddRepository {
    suspend fun addReservation(parkingId: String, reservation: Reservation): Result<Boolean>
}
