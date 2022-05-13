package com.example.parkingapp
//Modelo de datos para el listado de Lots

data class LotComponents(
    var parkingLot: Int,
    var reservationList: List<Reservation>)
