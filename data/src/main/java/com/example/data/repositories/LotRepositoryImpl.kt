package com.example.data.repositories
import com.example.data.repositories.service.LotService
import com.example.data.repositories.service.response.ParkingLotListResponse

import com.example.domain.model.Lot
import com.example.domain.model.Reservation
import com.example.domain.repositories.LotRepository

class LotRepositoryImpl : LotRepository {

//contains List of Lots
  lateinit var lotService: LotService

//bring list from the service
    override suspend fun getLotList(): List<Lot> {
        return lotService.getLotsMock()


    }
    //cambiar todas las llamadas para el retorno del nuevo valor Result<ParkingLotListResponse?>
  //  Result<ParkingLotListResponse?>
}