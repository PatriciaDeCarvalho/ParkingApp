package com.example.parkingapp.fragments

import com.example.domain.model.Lot
import java.io.Serializable

class Tests {

    data class Lot(
        val parkingLot: Int,
        val reservationList: List<Reservation>
    )

    data class Parking(
        val lotList: List<Lot>,
        val parkingSize: Int
    )

    data class Reservation(
        val authorizationCode: String,
        val starDateTimeInMillis: String, //change to long
        val endDateTimeInMillis: String, //change to long
        val parkingLot: Int
    )




}