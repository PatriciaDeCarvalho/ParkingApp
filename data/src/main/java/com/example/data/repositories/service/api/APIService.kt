package com.example.data.repositories.service.api

import com.example.data.repositories.service.response.ParkingLotListResponse
import com.example.data.repositories.service.response.ReservationListResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

// @GET("{parkingId}/reservations.json")
// suspend fun getReservations(@Path("parkingId")id:String): Response<ReservationListResponse>

//    @GET("parkings/{parkingId}/.json")
//    suspend fun getParkingLots(@Path("parkingId")id:String): Call< Response<ParkingLotListResponse>>
//
//    @DELETE("parkings/{parkingId}/.json")
//    fun deleteMascotaPorId(@Path ("id") id: String) : Call<SaveMascota>
//
////    @POST("{parkingId}/reservations.json")
////            suspend fun
@GET("parkings/{parkingId}/.json")
suspend fun getParkingLots(@Path("parkingId")id:String): Call< Response<ParkingLotListResponse>>
}

