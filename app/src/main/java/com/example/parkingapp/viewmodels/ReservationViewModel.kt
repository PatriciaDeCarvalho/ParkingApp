package com.example.parkingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Lot
import com.example.domain.model.Reservation
import com.example.domain.usecases.GetReservationListUseCase
import kotlinx.coroutines.launch

class ReservationViewModel(val getReservationListUseCase: GetReservationListUseCase) : ViewModel() {

    private val _reservations =  MutableLiveData<List<Reservation>>()
    val reservations: LiveData<List<Reservation>> = _reservations

//      fun loadReservations() = viewModelScope.launch {
//          val reservationResponse = getReservationListUseCase.getReservations()
//          _reservations.postValue(reservationResponse)
//      }

    fun deleteReservation(reservation: Reservation, entryCode: String) = viewModelScope.launch {
        val auxReservations = _reservations.value?.toMutableList()
        if (reservation.authorizationCode == entryCode) {
            auxReservations?.remove(reservation)
            _reservations.postValue(auxReservations!!)
        }
    }







}
