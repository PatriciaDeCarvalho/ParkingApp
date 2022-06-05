package com.example.data.repositories.service

import com.example.domain.model.Lot
import com.example.domain.model.Reservation


//receipt List of Lots
class LotService {
    suspend fun getLots(): List<Lot> {
        return listOf(
            Lot(1, listOf(Reservation("one", 11500000, 17600000, 1))),
            Lot(2, listOf(Reservation("two", 16000000, 19500000, 2))),
            Lot(3, listOf(Reservation("three", 12000000, 22000000, 2))),
            Lot(4, listOf(Reservation("four", 16000000, 17000000, 3))),
            Lot(5, listOf(Reservation("five", 16000000, 18600000, 4))),
            Lot(6, listOf(Reservation("eight", 16000000, 17000000, 5))),
            Lot(7, emptyList())
        )
    }
}