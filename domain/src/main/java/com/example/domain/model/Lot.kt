package com.example.domain.model

import java.io.Serializable

data class Lot (

    val parkingLot: Int,
    var reservationList: List<Reservation>
):Serializable