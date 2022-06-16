package com.example.data.repositories.room.mapper

import com.example.data.repositories.room.entities.LotRoom
import com.example.data.repositories.service.response.LotRespsonse
import com.example.domain.model.Lot

class LotMapperLocal :
    BaseMapperRepository<LotRoom, Lot, LotRespsonse> {

    override fun transformFromRoomToDomain(type: LotRoom): Lot = Lot(
        type.parkingLot
    )


    override fun transformFromDomainToRoom(type: Lot): LotRoom = LotRoom(
        type.parkingLot
    )

    override fun transformFromRepositoryToDomain(type: LotRespsonse): Lot = Lot(
        type.parkingLot
    )

    override fun transformFromRepositoryToRoom(type: LotRespsonse): LotRoom = LotRoom(
        type.parkingLot
        )

}