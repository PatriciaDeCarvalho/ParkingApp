package com.example.data.repositories.service.api


import com.example.data.repositories.service.response.*
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface APIService {


//    @DELETE("parkingId/{reservations}/.json")
//    suspend fun deleteReservation(@Path("parkingId") id: DeleteResponse

//    @POST("parkingId/{reservations}/.json")
//    suspend fun addReservations(@Path("parkingId") id: String): AddResponse

    @GET("parkings/{parkingId}/.json")
    suspend fun getParkingLots(@Path("parkingId") id: String): ParkingLotListResponse

    @GET("{parkingId}/reservations.json")
    suspend fun getReservations(@Path("parkingId") id: String): ReservationListResponse?
}
