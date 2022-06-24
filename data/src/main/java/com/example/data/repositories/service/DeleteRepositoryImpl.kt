package com.example.data.repositories.service

import com.example.domain.model.Reservation
import com.example.domain.repositories.DeleteRepository
import com.example.domain.util.Result


class DeleteRepositoryImpl: DeleteRepository {

    private val deleteService: ParkingService = ParkingService()
    override suspend fun deleteReservation(
        parkingId: String,
        reservation: Reservation,
        authorizationCode: String
    ): Result<Boolean> {

        var result = deleteService.deleteReservation(parkingId, reservation.id )

        return  when(result){
            is Result.Success -> {
                Result.Success(result.data )
            }
            is Result.Failure -> {
                Result.Failure(result.exception)

            }
        }

    }


}