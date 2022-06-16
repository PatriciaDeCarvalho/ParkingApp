package com.example.data.repositories.room.mapper

import com.example.data.repositories.room.entities.ReservationRoom
import com.example.data.repositories.service.response.ReservationListResponse
import com.example.data.repositories.service.response.ReservationResponse
import com.example.domain.model.Reservation

class ReservationMapperLocal :
    BaseMapperRepository<ReservationRoom, Reservation, ReservationResponse> {
    override fun transformFromRoomToDomain(type: ReservationRoom): Reservation = Reservation(
        type.id,
        type.authorizationCode,
        type.starDateTimeInMillis,
        type.endDateTimeInMillis,
        type.parkingLot
    )

    override fun transformFromDomainToRoom(type: Reservation): ReservationRoom = ReservationRoom(
        type.id,
        type.authorizationCode,
        type.starDateTimeInMillis,
        type.endDateTimeInMillis,
        type.parkingLot
    )

    override fun transformFromRepositoryToDomain(type: ReservationResponse): Reservation = Reservation (

    type.id,
    type.authorizationCode,
    type.startDate.toLong(),
    type.endDate.toLong(),
    type.parkingLot
    )

    override fun transformFromRepositoryToRoom(type: ReservationResponse):ReservationRoom = ReservationRoom (

    type.id,
    type.authorizationCode,
    type.startDate.toLong(),
    type.endDate.toLong(),
    type.parkingLot
    )

}