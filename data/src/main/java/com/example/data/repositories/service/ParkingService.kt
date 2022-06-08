package com.example.data.repositories.service
import  com.example.domain.util.Result
import com.example.data.repositories.service.api.APIService
import com.example.data.repositories.service.response.ParkingLotRespsonse
import com.example.data.repositories.service.response.ReservationResponse
import com.example.data.repositories.service.retrofitInstance.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext



//receipt List of Lots
class ParkingService {
    companion object {
        const val PARKING_ID = "-N0TU9Cpn15-TzSEcoSZ"
    }

    suspend fun getLots(): Result<List<ParkingLotRespsonse>> {
        var result: Result<List<ParkingLotRespsonse>>
        withContext(Dispatchers.IO) {

            result = try {
                val response = RetrofitInstance.getRetrofit().create(APIService::class.java).getParkingLots(PARKING_ID)
                //val response = callResponse
                if (response.lotList.isNotEmpty()) {
                    //llamar al maper para transformar Parking lot en parking lot list response
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


                if (response.reservationList.isNotEmpty()) {
                    //llamar al maper para transformar Parking lot en parking lot list response
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

}

//   fun getLotsMock(): List<Lot> {
//        return listOf(
//            Lot(1, listOf(Reservation("one", 11500000, 17600000, 1))),
//            Lot(2, listOf(Reservation("two", 16000000, 19500000, 2))),
//            Lot(3, listOf(Reservation("three", 12000000, 22000000, 2))),
//            Lot(4, listOf(Reservation("four", 16000000, 17000000, 3))),
//            Lot(5, listOf(Reservation("five", 16000000, 18600000, 4))),
//            Lot(6, listOf(Reservation("eight", 16000000, 17000000, 5))),
//            Lot(7, emptyList())
//        )
//    }