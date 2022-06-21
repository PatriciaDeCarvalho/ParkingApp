package com.example.data.repositories.service.request

import com.example.domain.model.Reservation

data class ReservationRequest(
    val authorizationCode: String,
    val startDate: Long,
    val endDate: Long,
    val parkingLot: Int,
                              )


