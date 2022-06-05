package com.example.data.repositories.service.response

data class ReservationResponse (var authorizationCode: String, val startDate: String, val endDate: String,  var parkingLot: Int)