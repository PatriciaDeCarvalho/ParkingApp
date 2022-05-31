package com.example.domain.model

import java.io.Serializable


data class Reservation (
    val authorizationCode:String,
    val starDateTimeInMillis:String, //change to long
    val endDateTimeInMillis:String, //change to long
    val parkingLot: Int): Serializable



