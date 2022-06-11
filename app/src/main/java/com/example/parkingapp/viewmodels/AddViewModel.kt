package com.example.parkingapp.viewmodels
import androidx.lifecycle.ViewModel
import com.example.data.repositories.service.ParkingService


class AddViewModel(listReservations: ParkingService): ViewModel() {

  //  private val reservationList:List<Reservation> = ParkingService.getReservations()

    var itemSelectedVM:Int = 0
    var enteredCodeVM:String = ""
    var startDateTimeVM:Long = 0
    var EndDateTimeVM:Long = 0



//fun addReservation(){
//
//  //  var reservation = listOf(enteredCodeVM,startDateTimeVM,EndDateTimeVM,itemSelectedVM,)
//  //  reservationList.add(reservation)
//}

}

