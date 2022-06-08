package com.example.data.repositories

import  com.example.domain.util.Result
import com.example.data.repositories.service.ParkingService
import com.example.domain.model.Lot
import com.example.domain.model.LotList

import com.example.domain.repositories.LotRepository

class LotRepositoryImpl : LotRepository {

    //contains List of Lots
    lateinit var lotService: ParkingService

    //bring list from the service
    override suspend fun getLotList(): LotList {
        var lotList = mutableListOf<Lot>()
        var result = lotService.getLots()
        var resultLotList = LotList(lotList)

        if (result is Result.Success) {
            result.data.forEach {
                lotList.add(Lot(it.parkingLot))
            }

        }
        resultLotList.lotList = lotList
        return resultLotList
    }
    //cambiar todas las llamadas para el retormo del nuevo valor Result<ParkingLotListResponse?>
    //  Result<ParkingLotListResponse?>
}