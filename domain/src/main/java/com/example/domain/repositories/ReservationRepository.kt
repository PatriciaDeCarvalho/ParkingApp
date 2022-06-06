package com.example.domain.repositories

import com.example.domain.model.Reservation

interface ReservationRepository {

    suspend fun getReservationsList(): List<Reservation>
}