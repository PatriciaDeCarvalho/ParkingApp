package com.example.data.repositories

import com.example.data.repositories.service.LotService
import com.example.data.repositories.service.retrofitInstance.ReservationService
import com.example.domain.model.Lot
import com.example.domain.model.Reservation
import com.example.domain.repositories.ReservationRepository

class ReservationRepositoryImpl: ReservationRepository {

    //contains List of Reservations
    lateinit var reservationService: ReservationService

    //bring list from the service
    override suspend fun getReservationsList(): List<Reservation> {
        return reservationService.getReservations()
    }

}