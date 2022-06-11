package com.example.data.repositories.service.request

import com.example.domain.model.Reservation

data class ReservationRequest(val authorizationCode: String,val endDate: Long, val parkingLot: Int,
                              val startDate: Long)


