package com.example.parkingapp
import com.example.domain.util.Result
import com.example.domain.model.Reservation
import com.example.domain.repositories.DeleteRepository
import com.example.domain.usecases.DeleteReservationUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test



class DeleteReservationUseCaseTest {

    @RelaxedMockK
    private lateinit var deleteRepository: DeleteRepository

    lateinit var deleteUseCase: DeleteReservationUseCase

    @Before
    fun setUp(){
        MockKAnnotations.init(this)
        deleteUseCase = DeleteReservationUseCase()
        deleteUseCase.deleteRepository = deleteRepository
    }

    @Test
    fun rightDelete() = runBlocking {

        var reservation = Reservation("","1",1,20,0)
        coEvery { deleteRepository.deleteReservation(authorizationCode = "1", parkingId = "1", reservation = reservation) } returns  Result.Success(true)

        deleteUseCase(authorizationCode = "1", parkingId = "1", reservation = reservation)

        coVerify (exactly = 1 ) { deleteRepository.deleteReservation(authorizationCode = "1", parkingId = "1", reservation = reservation) }
    }

    @Test
    fun wrongDelete() = runBlocking {

        var reservation = Reservation("","1",1,10,0)
        coEvery { deleteRepository.deleteReservation(authorizationCode = "1", parkingId = "1", reservation = reservation) } returns  Result.Success(false)

        deleteUseCase(authorizationCode = "1", parkingId = "1", reservation = reservation)

        coVerify (exactly = 0 ) { deleteRepository.deleteReservation(authorizationCode = "1", parkingId = "1", reservation = reservation) }
    }
}