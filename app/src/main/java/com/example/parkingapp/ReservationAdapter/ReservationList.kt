package com.example.parkingapp.ReservationAdapter

import com.example.parkingapp.Reservation

class ReservationList {
    companion object {
        var reservationList = listOf<Reservation>(
            Reservation(
                authorizationCode = "one",
                starDateTimeInMillis = "16000000",
                endDateTimeInMillis = "17000000",
                parkingLot = 2
            ),

            Reservation(
                authorizationCode = "two",
                starDateTimeInMillis = "16000000",
                endDateTimeInMillis = "17000000",
                parkingLot = 2
            ),

            Reservation(
                authorizationCode = "three",
                starDateTimeInMillis = "14000000",
                endDateTimeInMillis = "18000000",
                parkingLot = 2
            ),

            Reservation(
                authorizationCode = "four",
                starDateTimeInMillis = "12000000",
                endDateTimeInMillis = "13000000",
                parkingLot = 2
            ),

            Reservation(
                authorizationCode = "five",
                starDateTimeInMillis = "15000000",
                endDateTimeInMillis = "19000000",
                parkingLot = 2
            ),

            Reservation(
                authorizationCode = "six",
                starDateTimeInMillis = "6000000",
                endDateTimeInMillis = "7000000",
                parkingLot = 2
            ),

            Reservation(
                authorizationCode = "seven",
                starDateTimeInMillis = "10000000",
                endDateTimeInMillis = "11000000",
                parkingLot = 2
            ),

            Reservation(
                authorizationCode = "eight",
                starDateTimeInMillis = "18000000",
                endDateTimeInMillis = "19000000",
                parkingLot = 2
            ),

            Reservation(
                authorizationCode = "nine",
                starDateTimeInMillis = "12000000",
                endDateTimeInMillis = "15000000",
                parkingLot = 2
            )
        )
    }

}