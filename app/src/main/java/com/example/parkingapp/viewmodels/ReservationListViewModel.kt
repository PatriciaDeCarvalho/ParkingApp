package com.example.parkingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.parkingapp.lotAdapter.Lot
import com.example.parkingapp.reservationAdapter.Reservation

class ReservationListViewModel: ViewModel(){

    val reservationList: MutableLiveData<List<Reservation>> by lazy {
        MutableLiveData<List<Reservation>>().apply {
            value = getLotListReservations()
        }
    }


    private fun getLotListReservations() = listOf<Reservation>(
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
                parkingLot = 3
            ),

            Reservation(
                authorizationCode = "five",
                starDateTimeInMillis = "15000000",
                endDateTimeInMillis = "19000000",
                parkingLot = 1
            ),

            Reservation(
                authorizationCode = "six",
                starDateTimeInMillis = "6000000",
                endDateTimeInMillis = "7000000",
                parkingLot = 5
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
                parkingLot = 6
            ),

            Reservation(
                authorizationCode = "nine",
                starDateTimeInMillis = "12000000",
                endDateTimeInMillis = "15000000",
                parkingLot = 2
            )
    )

    }
