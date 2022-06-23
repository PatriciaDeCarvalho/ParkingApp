package com.example.domain.repositories

import com.example.domain.model.Reservation
import com.example.domain.util.Result

interface DeleteRepository {

    /*TODO The name of a repository class should star with the name of the entity
       in this case, ReservationRepository
       the method deleteReservation should be in ReservationRepository
       You only name a class starting with a verb the usescases, like DeleteReservationUseCase
     */
    suspend fun deleteReservation(parkingId: String, reservation: Reservation, authorizationCode: String): Result<Boolean>
}