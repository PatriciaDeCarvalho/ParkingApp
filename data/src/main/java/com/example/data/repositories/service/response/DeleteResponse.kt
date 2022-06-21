package com.example.data.repositories.service.response

import com.google.gson.annotations.SerializedName

class DeleteResponse (
    @SerializedName("deleteReservation")
    val reservationId: String,
    val parkingId: String)

