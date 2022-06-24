package com.example.data.repositories.service.response

import com.google.gson.annotations.SerializedName


data class LotResponse (
    @SerializedName("parkingLot")
    var parkingLot:Int)