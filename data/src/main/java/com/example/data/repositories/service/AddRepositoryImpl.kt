package com.example.data.repositories.service

import com.example.data.repositories.service.request.ReservationRequest
import com.example.domain.model.Reservation
import com.example.domain.repositories.AddRepository
import com.example.domain.util.Result

class AddRepositoryImpl: AddRepository {

    private val addService: ParkingService = ParkingService()

    override suspend fun addReservation(
        parkingId: String,
        reservation: Reservation
    ): Result<Boolean> {

        val result = addService.addReservation(
            (parkingId), ReservationRequest(
                reservation.authorizationCode, reservation.starDateTimeInMillis,
                reservation.endDateTimeInMillis, reservation.parkingLot
            )
        )

        return when (result) {

            is Result.Success -> {
                Result.Success(result.data )
            }
            is Result.Failure -> {
                Result.Failure(result.exception)

            }
        }

    }
}

