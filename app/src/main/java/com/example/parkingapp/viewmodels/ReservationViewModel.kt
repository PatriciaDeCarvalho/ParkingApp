package com.example.parkingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Lot
import com.example.domain.model.Reservation
import com.example.domain.usecases.DeleteReservationUseCase
import com.example.domain.usecases.GetReservationListUseCase
import com.example.domain.util.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReservationViewModel(val deleteReservationUseCase: DeleteReservationUseCase) : ViewModel() {
    private val parkingId = "-N0TU9Cpn15-TzSEcoSZ"
    private val mutableSuccessfulDelete = MutableLiveData<Boolean>()
    val successfulDelete: LiveData<Boolean> = mutableSuccessfulDelete


    fun deleteReservation(reservation: Reservation, authorizationCode: String) =
        viewModelScope.launch {

            if (reservation.authorizationCode == authorizationCode) {
                val deleteReservation = withContext(Dispatchers.IO) {
                    deleteReservationUseCase(
                        parkingId,
                        reservation,
                        authorizationCode
                    )
                }
                when (deleteReservation) {
                    is Result.Success -> {
                        mutableSuccessfulDelete.value = true
                    }
                    is Result.Failure -> {
                        mutableSuccessfulDelete.value = false
                    }
                }
            } else {
                mutableSuccessfulDelete.value = false
            }

        }


}
