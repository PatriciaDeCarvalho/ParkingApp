package com.example.domain.model

import java.io.Serializable


data class Reservation (
    val authorizationCode:String,
    val starDateTimeInMillis:Long, //change to long
    val endDateTimeInMillis:Long, //change to long
    val parkingLot: Int): Serializable



