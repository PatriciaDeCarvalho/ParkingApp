package com.example.parkingapp.reservationAdapter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//Modelo de datos para el listado de Reservas
@Parcelize
data class Reservation (
    val authorizationCode:String,
    val starDateTimeInMillis:String, //change to long
    val endDateTimeInMillis:String, //change to long
    val parkingLot: Int):Parcelable



