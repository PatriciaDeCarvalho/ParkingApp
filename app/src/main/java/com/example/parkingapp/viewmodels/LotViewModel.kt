package com.example.parkingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.*
import com.example.domain.usecases.GetLotListUseCase
import com.example.domain.usecases.GetReservationListUseCase
import com.example.parkingapp.uientity.LotProgress

import kotlinx.coroutines.launch

class LotViewModel(

    private val getLotListUseCase: GetLotListUseCase,
    private val getReservationListUseCase: GetReservationListUseCase
) : ViewModel() {

    private val _lots = MutableLiveData<List<LotReservation>>()
    val lots: LiveData<List<LotReservation>> = _lots

    private val _reservations = MutableLiveData<ReservationList>()
    val reservations: LiveData<ReservationList>? = _reservations

    private val _lotProgress = MutableLiveData<LotProgress>()
    val lotProgress: LiveData<LotProgress> = _lotProgress



//    fun loadData() = viewModelScope.launch {
//        var lots = getLotListUseCase.getLots()
//        var reservations = getReservationListUseCase.getReservations()
//        var result = mutableListOf<LotReservation>()
//
//        lots.lotList.forEach {
//            var lotId = it.parkingLot
//            var lotReservation = LotReservation(lotId)
//            var reservationListLots = mutableListOf<Reservation>()
//            reservations.reservationList.forEach {
//
//                if (lotId == it.parkingLot) {
//                    reservationListLots.add(it)
//
//                }
//            }
//            lotReservation.reservationList = reservationListLots
//            result.add(lotReservation)
//        }
//        var lotsFree: Int = 0
//        var lotsBusy: Int = 0
//
//        result.forEach {
//            if (it.reservationList?.isNotEmpty()!!) {
//                lotsBusy++
//            } else {
//                lotsFree++
//            }
//        }
//     var progressLot = LotProgress(lotsFree,lotsBusy)
//        _lotProgress.postValue(progressLot)
//        _lots.postValue(result)
//    }


}




