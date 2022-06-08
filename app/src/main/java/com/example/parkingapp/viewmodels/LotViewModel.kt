package com.example.parkingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repositories.LotRepositoryImpl
import com.example.domain.model.Lot
import com.example.domain.model.LotList
import com.example.domain.model.ReservationList
import com.example.domain.repositories.LotRepository
import com.example.domain.usecases.GetLotListUseCase
import com.example.domain.usecases.GetReservationListUseCase

import kotlinx.coroutines.launch

class LotViewModel( private val getLotListUseCase : GetLotListUseCase,
                    private val getReservationListUseCase : GetReservationListUseCase) : ViewModel() {
    private val _lots = MutableLiveData<LotList>()
    val lots: LiveData<LotList> = _lots

    private val _reservations = MutableLiveData<ReservationList>()
    val reservations: LiveData<ReservationList> = _reservations

    fun loadLots() = viewModelScope.launch {
        val lotResponse = getLotListUseCase.getLots()
        _lots.postValue(lotResponse)
    }

    fun loadReservations() = viewModelScope.launch {
        val reservationResponse = getReservationListUseCase.getReservations()
        _reservations.postValue(reservationResponse)
    }






    }




