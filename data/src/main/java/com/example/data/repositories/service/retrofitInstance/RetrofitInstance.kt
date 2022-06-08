package com.example.data.repositories.service.retrofitInstance

import com.example.data.repositories.service.response.ReservationListResponse
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor

object RetrofitInstance {

    private const val BASE_URL = "https://parking-lot-5aace-default-rtdb.firebaseio.com/"

    private val httpClient = OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY })

    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(getGsonBuilder()))
            .client(httpClient.build())
            .build()
    }

    private fun getGsonBuilder() =
        GsonBuilder().registerTypeAdapter(ReservationListResponse::class.java, RealTimeDatabaseDeserializer()).create()
}
