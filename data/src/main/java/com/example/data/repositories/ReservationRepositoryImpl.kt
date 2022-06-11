package com.example.data.repositories

import com.example.data.repositories.service.ParkingService
import com.example.domain.model.Reservation
import com.example.domain.model.ReservationList
import com.example.domain.repositories.ReservationRepository
import com.example.domain.util.Result

class ReservationRepositoryImpl: ReservationRepository {

    //contains List of Reservations
    lateinit var parkingService: ParkingService

    override suspend fun getReservationsList(): ReservationList {
        val mutableReservationList = mutableListOf<Reservation>()
        val reservationList = ReservationList(mutableReservationList)

       val result =  parkingService.getReservations()


        if (result is Result.Success) {
            result.data.forEach {reservation ->
                mutableReservationList.add(Reservation(reservation.id, reservation.authorizationCode,reservation.startDate.toLong(),
                    reservation.endDate.toLong(), reservation.parkingLot))
            }

        }
        reservationList.reservationList = mutableReservationList
        return reservationList
    }

    override suspend fun deleteReservation(reservation: Reservation, entryCode: String): Boolean {
   //     val result = parkingService.deleteReservation(reservation.parkingLot.toString(), reservation. )
        return true
    }


}

