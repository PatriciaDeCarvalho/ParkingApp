package com.example.data.repositories.service
import  com.example.domain.util.Result
import com.example.data.repositories.service.api.APIService
import com.example.data.repositories.service.request.ReservationRequest
import com.example.data.repositories.service.response.LotResponse
import com.example.data.repositories.service.response.ReservationResponse
import com.example.data.repositories.service.retrofitInstance.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ParkingService {
    companion object {
        const val PARKING_ID = "-N0TU9Cpn15-TzSEcoSZ"
    }

    suspend fun getLots(): Result<List<LotResponse>> {
        var result: Result<List<LotResponse>>
        withContext(Dispatchers.IO) {

            result = try {
                val response = RetrofitInstance.getRetrofit().create(APIService::class.java).getParkingLots(PARKING_ID)

                if (response.lotList.isNotEmpty()) {

                    Result.Success(response.lotList)
                } else {
                    Result.Failure(Exception("Ocurrio un error"))
                }
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }
        return result
    }


    suspend fun getReservations(): Result<List<ReservationResponse>> {
        var result: Result<List<ReservationResponse>>
        withContext(Dispatchers.IO) {

            result = try {
                val response = RetrofitInstance.getRetrofit().create(APIService::class.java).getReservations(
                    PARKING_ID)

                if (response?.reservationList?.isNotEmpty()!!) { /** Do not let too much blank spaces */

                    Result.Success(response.reservationList)
                } else {
                    Result.Failure(Exception("Ocurrio un error"))
                }
            } catch (e: Exception) {
                Result.Failure(e)
            }
        }
        return result
    }
    suspend fun deleteReservation(parkingId: String, reservationId: String):Result<Boolean>{
        var result: Result<Boolean>
        withContext(Dispatchers.IO) {

            result = try {
                val response = RetrofitInstance.getRetrofit().create(APIService::class.java).deleteReservation(
                    parkingId, reservationId)
                if(response.isSuccessful){
                    Result.Success(true)
                }else{
                    Result.Failure(Exception(response.message()))
                }

            }catch (e: Exception){
                Result.Failure(e)
            }
        }
        return result
    }

    suspend fun addReservation(parkingId: String, reservation: ReservationRequest):Result<Boolean>{
        var result: Result<Boolean>
        withContext(Dispatchers.IO) {

            result = try {
                val response = RetrofitInstance.getRetrofit().create(APIService::class.java).addReservations(
                    parkingId, reservation)
                if(response.isSuccessful){
                    Result.Success(true)
                }else{
                    Result.Failure(Exception(response.message()))
                }

            }catch (e: Exception){
                Result.Failure(e)
            }
        }
        return result
    }
}

