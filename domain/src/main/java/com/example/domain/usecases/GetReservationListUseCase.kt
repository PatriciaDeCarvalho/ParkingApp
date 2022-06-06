package com.example.domain.usecases

import com.example.domain.repositories.ReservationRepository

class GetReservationListUseCase {
    lateinit var reservRepository: ReservationRepository
    suspend fun getReservations() = reservRepository.getReservationsList()
}