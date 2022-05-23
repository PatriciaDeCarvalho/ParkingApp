package com.example.parkingapp.reservationAdapter

//Modelo de datos para el listado de Reservas

data class Reservation (
    val authorizationCode:String,
    val starDateTimeInMillis:String, //change to long
    val endDateTimeInMillis:String, //change to long
    val parkingLot: Int)



