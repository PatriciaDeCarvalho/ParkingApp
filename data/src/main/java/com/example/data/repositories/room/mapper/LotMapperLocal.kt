package com.example.data.repositories.room.mapper

import com.example.data.repositories.room.entities.LotRoom
import com.example.data.repositories.service.response.LotResponse
import com.example.domain.model.Lot

class LotMapperLocal :
    BaseMapperRepository<LotRoom, Lot, LotResponse> {

    override fun transformFromRoomToDomain(type: LotRoom): Lot = Lot(
        type.parkingLot
    )


    override fun transformFromDomainToRoom(type: Lot): LotRoom = LotRoom(
        type.parkingLot
    )

    override fun transformFromRepositoryToDomain(type: LotResponse): Lot = Lot(
        type.parkingLot
    )

    override fun transformFromRepositoryToRoom(type: LotResponse): LotRoom = LotRoom(
        type.parkingLot
        )

}