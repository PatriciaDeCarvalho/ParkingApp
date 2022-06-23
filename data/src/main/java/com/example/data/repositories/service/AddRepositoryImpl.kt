package com.example.data.repositories.service

import com.example.data.repositories.service.request.ReservationRequest
import com.example.domain.model.Reservation
import com.example.domain.repositories.AddRepository
import com.example.domain.util.Result

/*TODO The name of a repository class should star with the name of the entity
   in this case, ReservationRepositoryImpl
   the method addReservation should be in ReservationRepository and then you should implement it in ReservationRepositoryImpl
   You only name a class starting with a verb the usescases, like AddReservationUseCase
  */
class AddRepositoryImpl : AddRepository {

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
                Result.Success(result.data)
            }
            is Result.Failure -> {
                Result.Failure(result.exception)

            }
        }

    }
}

