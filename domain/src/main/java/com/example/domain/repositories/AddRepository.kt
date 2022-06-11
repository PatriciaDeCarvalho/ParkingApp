package com.example.domain.repositories

import com.example.domain.model.Reservation

interface AddRepository {
    suspend fun addReservation(parkingId: String, reservation: Reservation): Result<Boolean>
}
