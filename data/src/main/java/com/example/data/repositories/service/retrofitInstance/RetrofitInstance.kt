package com.example.data.repositories.service.retrofitInstance

import com.example.data.repositories.service.response.ReservationListResponse
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private const val BASE_URL =""

        fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(getGsonBuilder()))
                .build()

        }
    private fun getGsonBuilder()= GsonBuilder().registerTypeAdapter(ReservationListResponse::class.java,
        RealTimeDatabaseDeserializer()).create()
//pegar esta clase en el mismo paquete
}