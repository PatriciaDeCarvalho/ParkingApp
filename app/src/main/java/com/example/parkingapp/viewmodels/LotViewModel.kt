package com.example.parkingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.*
import com.example.domain.usecases.GetLotListUseCase
import com.example.domain.usecases.GetReservationListUseCase
import com.example.parkingapp.utils.LotProgress
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class LotViewModel(

    private val getLotListUseCase: GetLotListUseCase,
    private val getReservationListUseCase: GetReservationListUseCase
) : ViewModel() {

    private val _lots = MutableLiveData<List<LotReservation>>()
    val lots: LiveData<List<LotReservation>> = _lots

    private val _lotProgress = MutableLiveData<LotProgress>()
    val lotProgress: LiveData<LotProgress> = _lotProgress


    fun loadData() = viewModelScope.launch {
        val lots = withContext(Dispatchers.IO) {getLotListUseCase.getLots()}
        val reservations = withContext(Dispatchers.IO) {getReservationListUseCase.getReservations()}
        val result = mutableListOf<LotReservation>()

        lots.lotList.forEach {
            val lotId = it.parkingLot
            val lotReservation = LotReservation(lotId)
            val reservationListLots = mutableListOf<Reservation>()
            reservations.reservationList.forEach {

                if (lotId == it.parkingLot) {
                    reservationListLots.add(it)

                }
            }
            lotReservation.reswervationList = reservationListLots
            result.add(lotReservation)
        }
        var lotsFree: Int = 0
        var lotsBusy: Int = 0

        result.forEach {
            if (it.reswervationList?.isNotEmpty()!!) {
                lotsBusy++
            } else {
                lotsFree++
            }
        }
        val progressLot = LotProgress(lotsFree,lotsBusy)
        _lotProgress.postValue(progressLot)
        _lots.postValue(result)
    }


}




