package com.example.data.repositories.service.response

import com.google.gson.annotations.SerializedName

/*TODO If you don't use a class, delete it from the project*/
class DeleteResponse (
    @SerializedName("deleteReservation")
    val reservationId: String,
    val parkingId: String)

