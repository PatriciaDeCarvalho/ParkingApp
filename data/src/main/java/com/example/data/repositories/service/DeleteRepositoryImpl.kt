package com.example.data.repositories.service

import com.example.domain.model.Reservation
import com.example.domain.repositories.DeleteRepository
import com.example.domain.util.Result

/*TODO The name of a repository class should star with the name of the entity
   in this case, ReservationRepositoryImpl
   the method deleteReservation should be in ReservationRepository and then you should implement it in ReservationRepositoryImpl
   You only name a class starting with a verb the usescases, like AddReservationUseCase
  */
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