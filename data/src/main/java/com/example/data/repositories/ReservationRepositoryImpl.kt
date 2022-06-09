package com.example.data.repositories

import com.example.data.repositories.service.ParkingService
import com.example.data.repositories.service.ReservationService
import com.example.data.repositories.service.response.ReservationResponse
import com.example.domain.model.Lot
import com.example.domain.model.Reservation
import com.example.domain.model.ReservationList
import com.example.domain.repositories.ReservationRepository
import com.example.domain.util.Result

class ReservationRepositoryImpl: ReservationRepository {

    //contains List of Reservations
    lateinit var parkingService: ParkingService

    override suspend fun getReservationsList(): ReservationList {
        var mutableReservationList = mutableListOf<Reservation>()
        var reservationList = ReservationList(mutableReservationList)

       var result =  parkingService.getReservations()


        if (result is Result.Success) {
            result.data.forEach {reservation ->
                mutableReservationList.add(Reservation(reservation.authorizationCode,reservation.startDate,
                    reservation.endDate, reservation.parkingLot))
            }

        }
        reservationList.reservationList = mutableReservationList
        return reservationList
    }



    }

