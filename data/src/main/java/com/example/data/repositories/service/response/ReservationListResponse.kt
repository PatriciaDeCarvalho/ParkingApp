package com.example.data.repositories.service.response

import com.google.gson.annotations.SerializedName

data class ReservationListResponse (
    @SerializedName("reservationList")
    var reservationList: MutableList<ReservationResponse>)
