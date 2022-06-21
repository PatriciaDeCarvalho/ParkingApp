package com.example.parkingapp

import com.example.data.repositories.LotRepositoryImpl
import com.example.domain.model.LotList
import com.example.domain.repositories.LotRepository
import com.example.domain.usecases.GetLotListUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class GetLotUseCaseTest {
//    @RelaxedMockK
//    private lateinit var repository: LotRepository
//    lateinit var getLotListUseCase: GetLotListUseCase
//
//    @Before
//    fun onBefore() {
//        MockKAnnotations.init(this)
//        getLotListUseCase = GetLotListUseCase()
//
//    }
//
//    @Test
//    fun getLotTest() = runBlocking {
//
//        coEvery { repository.getLotList() } returns LotList()
//        getLotListUseCase
//
//        coVerify {( repository.getLotList()) }
//    }
}