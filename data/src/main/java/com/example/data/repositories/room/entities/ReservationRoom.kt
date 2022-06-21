package com.example.data.repositories.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Reservation")
data class ReservationRoom(

    @PrimaryKey
    val id: String,
    val authorizationCode: String,
    val starDateTimeInMillis: Long,
    val endDateTimeInMillis: Long,
    val parkingLot: Int //: Serializable

)