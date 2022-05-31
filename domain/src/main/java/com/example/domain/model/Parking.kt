package com.example.domain.model

import com.example.domain.model.Lot

data class Parking(
    val lotList: List<Lot>,
    val parkingSize: Int
)



