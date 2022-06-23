package com.example.parkingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.*
import com.example.domain.usecases.GetLotListUseCase
import com.example.domain.usecases.GetReservationListUseCase
import com.example.parkingapp.Utils.LotProgress
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/*TODO 5 advice: why when you want to pass data a livedata is observed in fragment? and in the viewmodel you set values on mutablelive data?, answer it for yourself*/
/*TODO 6 Why viewModelScope.launch is needed here? what it does? answer it for yourself*/
/*TODO 7 Why withContext(Dispatchers.IO) is needed here? what it does? answer it for yourself*/
/*TODO 8 Read all the dependencies you have used in gradle files, and understand what is for everyone, it's importante you know why you are using it*/
class LotViewModel(

    private val getLotListUseCase: GetLotListUseCase,
    private val getReservationListUseCase: GetReservationListUseCase
) : ViewModel() {

    private val _lots = MutableLiveData<List<LotReservation>>()
    val lots: LiveData<List<LotReservation>> = _lots

    private val _reservations = MutableLiveData<ReservationList>() /**TODO if you do not use it, delete it */
    val reservations: LiveData<ReservationList>? = _reservations

    private val _lotProgress = MutableLiveData<LotProgress>()

    val lotProgress: LiveData<LotProgress> = _lotProgress


    fun loadData() = viewModelScope.launch {
        val lots = withContext(Dispatchers.IO) {getLotListUseCase.getLots()}
        //when (val result = withContext(Dispatchers.IO) { getCharacterById(id, true) })
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




