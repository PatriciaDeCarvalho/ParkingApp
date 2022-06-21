package com.example.data.repositories.service.response

import com.google.gson.annotations.SerializedName

data class ParkingLotListResponse(
    @SerializedName("lotList")
    var lotList:List<LotRespsonse>)