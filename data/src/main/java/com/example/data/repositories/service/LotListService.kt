package com.example.data.repositories.service
import  com.example.domain.util.Result
import com.example.data.repositories.service.api.APIService
import com.example.data.repositories.service.response.ParkingLotListResponse
import com.example.data.repositories.service.response.ParkingLotRespsonse
import com.example.data.repositories.service.retrofitInstance.RetrofitInstance
import com.example.domain.model.Lot
import com.example.domain.model.LotList
import com.example.domain.model.Reservation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response


//receipt List of Lots
class LotListService {
    companion object {
        const val PARKING_ID = "-N0TU9Cpn15-TzSEcoSZ"
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

    suspend fun getLots(): Result<MutableList<ParkingLotRespsonse>> {
        var result: Result<MutableList<ParkingLotRespsonse>>
        withContext(Dispatchers.IO) {

            result = try {
                val callResponse = RetrofitInstance.getRetrofit().create(APIService::class.java).getParkingLots(PARKING_ID)
                val response = callResponse.execute()
                if (response.isSuccessful) {
                    //llamar al maper para transformal Parking lot en parking lot list response
                    Result.Success(response.body()?.body()?.lotList!!)
                } else {
                    Result.Failure(Exception(response.message()))
                }
            } catch (e: Exception) {
                Result.Failure(e)
            }

        }
        return result
    }
}