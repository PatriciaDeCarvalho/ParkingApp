package com.example.domain.model

import java.io.Serializable

data class LotReservation (
    var parkingLot: Int,
    var reswervationList: MutableList<Reservation>? = null
        ):Serializable


