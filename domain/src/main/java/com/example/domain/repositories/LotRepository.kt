package com.example.domain.repositories


import com.example.domain.model.LotList

interface LotRepository {

   suspend fun getLotList() :LotList
}