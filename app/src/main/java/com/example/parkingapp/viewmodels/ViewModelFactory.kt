package com.example.parkingapp.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.repositories.LotRepositoryImpl
import com.example.data.repositories.ReservationRepositoryImpl
import com.example.data.repositories.service.AddRepositoryImpl
import com.example.data.repositories.service.DeleteRepositoryImpl
import com.example.data.repositories.service.ParkingService
import com.example.domain.usecases.AddReservationUseCase
import com.example.domain.usecases.DeleteReservationUseCase
import com.example.domain.usecases.GetLotListUseCase
import com.example.domain.usecases.GetReservationListUseCase

class ViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == LotViewModel::class.java) {
            return LotViewModel(GetLotListUseCase().apply {
                repository = LotRepositoryImpl().apply {
                    lotService = ParkingService()
                }
            }, GetReservationListUseCase().apply {
                reservRepository = ReservationRepositoryImpl().apply {
                    parkingService = ParkingService()
                }
            }) as T

        } else if (modelClass == ReservationViewModel::class.java) {
            return ReservationViewModel(DeleteReservationUseCase().apply {
                deleteRepository = DeleteRepositoryImpl()
            }) as T

        } else if (modelClass == AddViewModel::class.java) {
            return AddViewModel(AddReservationUseCase().apply{
                addReservationRepository = AddRepositoryImpl()

            }) as T
        }

        return super.create(modelClass)
    }
}




