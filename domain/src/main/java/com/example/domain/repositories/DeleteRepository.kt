package com.example.domain.repositories

import com.example.domain.model.Reservation
import com.example.domain.util.Result

interface DeleteRepository {


    suspend fun deleteReservation(parkingId: String, reservation: Reservation, authorizationCode: String): Result<Boolean>
}