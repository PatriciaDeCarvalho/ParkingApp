package com.example.domain.usecases

import com.example.domain.model.Reservation
import com.example.domain.repositories.DeleteRepository
import com.example.domain.util.Result

class DeleteReservationUseCase {

    lateinit var repository: DeleteRepository

    suspend operator fun invoke(parkingId: String,reservation: Reservation, authorizationCode: String ): Result<Boolean>{
        return repository.deleteReservation(parkingId, reservation, authorizationCode)
    }

}


