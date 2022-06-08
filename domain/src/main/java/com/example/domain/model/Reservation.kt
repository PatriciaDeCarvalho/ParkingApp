package com.example.domain.model

import java.io.Serializable


data class Reservation (

    val authorizationCode:String,
    val starDateTimeInMillis:String,
    val endDateTimeInMillis:String,
    val parkingLot: Int): Serializable



