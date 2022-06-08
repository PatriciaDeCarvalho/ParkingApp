package com.example.domain.repositories

import com.example.domain.model.Reservation
import com.example.domain.model.ReservationList

interface ReservationRepository {

    suspend fun getReservationsList(): ReservationList
}