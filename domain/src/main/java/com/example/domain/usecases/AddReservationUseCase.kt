package com.example.domain.usecases

import com.example.domain.model.Reservation
import com.example.domain.repositories.AddRepository
import com.example.domain.util.Result

class AddReservationUseCase {

    lateinit var addReservationRepository: AddRepository
    suspend operator fun invoke(parkingId: String, reservation: Reservation): Result<Boolean>{
        return addReservationRepository.addReservation(parkingId,reservation)
    }
}



