package com.example.parkingapp.viewmodels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repositories.service.ParkingService
import com.example.domain.model.Reservation
import com.example.domain.model.ReservationList
import com.example.domain.usecases.AddReservationUseCase
import com.example.domain.util.Result
import kotlinx.coroutines.launch


class AddViewModel(val addReservationUseCase: AddReservationUseCase): ViewModel() {
    private val parkingId = "-N0TU9Cpn15-TzSEcoSZ"
    private val mutableSuccessfulAdd = MutableLiveData<Boolean>()
    val successfulAdd: LiveData<Boolean> = mutableSuccessfulAdd

    fun addReservation(reservation: Reservation)=
        viewModelScope.launch {

            if (reservation.authorizationCode != null &&
                reservation.endDateTimeInMillis != null &&
                reservation.starDateTimeInMillis != null &&
                reservation.parkingLot != null
            ) {

                val addReservation = addReservationUseCase(parkingId, reservation)
                when (addReservation) {
                    is Result.Success -> {
                        mutableSuccessfulAdd.postValue(true)
                    }
                    is Result.Failure -> {
                        mutableSuccessfulAdd.postValue(false)
                    }
                }
            }
            else {
                mutableSuccessfulAdd.postValue(false)
            }


        }
}

