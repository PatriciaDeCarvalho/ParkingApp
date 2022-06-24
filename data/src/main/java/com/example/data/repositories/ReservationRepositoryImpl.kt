package com.example.data.repositories

import com.example.data.repositories.room.dataBase.DataBase
import com.example.data.repositories.room.mapper.ReservationMapperLocal
import com.example.data.repositories.service.ParkingService
import com.example.data.repositories.service.response.ReservationResponse
import com.example.domain.model.Reservation
import com.example.domain.model.ReservationList
import com.example.domain.repositories.ReservationRepository
import com.example.domain.util.Result

class ReservationRepositoryImpl(private var parkingService: ParkingService,
                                private var  parkingDataBase: DataBase): ReservationRepository {



    override suspend fun getReservationsList(): ReservationList {
        val mutableReservationList = mutableListOf<Reservation>()
        val reservationList = ReservationList(mutableReservationList)

            val result =  parkingService.getReservations()

            if (result is Result.Success) {
                parkingDataBase.getReservationDao().deleteReservations()
                result.data.forEach {reservation ->
                    saveToDataBase(reservation)
                }

            }
            reservationList.reservationList = getLocalInfo()

        return reservationList
    }
        private suspend fun saveToDataBase(reservation: ReservationResponse){

            val localReservation = ReservationMapperLocal().transformFromRepositoryToRoom(reservation)

            parkingDataBase.getReservationDao().addReservation(localReservation)
        }
         suspend private fun getLocalInfo(): MutableList<Reservation>{

           val databaseReservations =  parkingDataBase.getReservationDao().getReservations()
            val reservationList = mutableListOf<Reservation>()
            databaseReservations.forEach{
                reservationList.add(ReservationMapperLocal().transformFromRoomToDomain(it))

            }
            return reservationList
        }


    override suspend fun deleteReservation(reservation: Reservation, entryCode: String): Boolean {
   //     val result = parkingService.deleteReservation(reservation.parkingLot.toString(), reservation. )
        return true
    }



}

