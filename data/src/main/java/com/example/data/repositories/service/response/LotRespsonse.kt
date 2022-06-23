package com.example.data.repositories.service.response

import com.google.gson.annotations.SerializedName

/*TODO the IDE shows you with a green underline that something is wrong, in this case the spelling, always check and correct*/
data class LotRespsonse (
    @SerializedName("parkingLot")
    var parkingLot:Int)