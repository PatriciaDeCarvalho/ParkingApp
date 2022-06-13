package com.example.data.repositories.service.api


import com.example.data.repositories.service.request.ReservationRequest
import com.example.data.repositories.service.response.*
import retrofit2.Response
import retrofit2.http.*

interface APIService {


    @DELETE("{parkingId}/reservations/{reservationId}.json")
    suspend fun deleteReservation(@Path("parkingId") parkingId: String,@Path("reservationId") reservationId: String): Response<Any?>

    @POST("{parkingId}/reservations.json")
    suspend fun addReservations(@Path("parkingId") id: String, @Body reservationRequest: ReservationRequest): Response<Any>

    @GET("parkings/{parkingId}/.json")
    suspend fun getParkingLots(@Path("parkingId") id: String): ParkingLotListResponse

    @GET("{parkingId}/reservations.json")
    suspend fun getReservations(@Path("parkingId") id: String): ReservationListResponse?
}
