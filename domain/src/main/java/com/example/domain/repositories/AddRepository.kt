package com.example.domain.repositories

import com.example.domain.model.Lot

interface AddRepository {

        fun addReservation(
            lot: Int,
            startDateTime: String,
            endDateTime: String,
            authorizationCode: Int): Boolean
}