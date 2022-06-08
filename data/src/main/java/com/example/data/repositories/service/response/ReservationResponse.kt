package com.example.data.repositories.service.response
import com.google.gson.annotations.SerializedName

data class ReservationResponse(
    @SerializedName("reservation")
    var id: String,
    var authorizationCode: String,
    var startDate: String,
    var endDate: String,
    var parkingLot: Int)



//data class ReservationResponse(
//    var id: String,
//    var authorizationCode: String,
//    var startDate: String,
//    var endDate: String,
//    var parkingLot: Int)


