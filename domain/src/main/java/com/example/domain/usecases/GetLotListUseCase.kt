package com.example.domain.usecases

import com.example.domain.model.Lot
import com.example.domain.model.Reservation
import com.example.domain.repositories.LotRepository

class GetLotListUseCase {
    lateinit var repository: LotRepository

    suspend fun getLots() = repository.getLotList()



}