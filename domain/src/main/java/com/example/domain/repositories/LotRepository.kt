package com.example.domain.repositories

import com.example.domain.model.Lot

interface LotRepository {

   suspend fun getLotList() : List<Lot>
}