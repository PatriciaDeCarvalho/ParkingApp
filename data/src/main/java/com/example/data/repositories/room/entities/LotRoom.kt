package com.example.data.repositories.room.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.model.Reservation

@Entity(tableName = "Lot")
data class LotRoom(

    @PrimaryKey
    var parkingLot: Int,

)





