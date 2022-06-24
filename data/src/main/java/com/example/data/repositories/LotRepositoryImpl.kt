

package com.example.data.repositories

import com.example.data.repositories.room.dataBase.DataBase
import com.example.data.repositories.room.mapper.LotMapperLocal
import  com.example.domain.util.Result
import com.example.data.repositories.service.ParkingService
import com.example.data.repositories.service.response.LotResponse
import com.example.domain.model.Lot
import com.example.domain.model.LotList

import com.example.domain.repositories.LotRepository

class LotRepositoryImpl( var parkingService: ParkingService,
                         var  parkingDataBase: DataBase ) : LotRepository {


    override suspend fun getLotList(): LotList {

        val mutableLotList = mutableListOf<Lot>()
        val lotList = LotList(mutableLotList)

        val result =  parkingService.getLots()

        if (result is Result.Success) {
            result.data.forEach {lot ->
                saveToDataBase(lot)
            }

        }
        lotList.lotList = getLocalInfo()
        return lotList
    }
    private suspend fun saveToDataBase(lot: LotResponse ){
        val localLot = LotMapperLocal().transformFromRepositoryToRoom(lot)

        parkingDataBase.getLotsDao().addLot(localLot)
    }
    private fun getLocalInfo(): MutableList<Lot>{
        val dataBaseLots = parkingDataBase.getLotsDao().getLots()
        val lotList = mutableListOf<Lot>()
        dataBaseLots.forEach{
            lotList.add(LotMapperLocal().transformFromRoomToDomain(it))
        }
        return lotList
    }

}















//package com.example.data.repositories
//
//import com.example.data.repositories.room.dataBase.DataBase
//import com.example.data.repositories.room.mapper.LotMapperLocal
//import  com.example.domain.util.Result
//import com.example.data.repositories.service.ParkingService
//import com.example.domain.model.Lot
//import com.example.domain.model.LotList
//
//import com.example.domain.repositories.LotRepository
//
//class LotRepositoryImpl : LotRepository {
//
//    //contains List of Lots
//    lateinit var lotService: ParkingService
//    lateinit var lotDataBase: DataBase
//
//    private val mapper = LotMapperLocal()
//
//
//
//    override suspend fun getLotList(getFromRemote: Boolean): LotList =
//        if (getFromRemote) {
//            val lotList = mutableListOf<Lot>()
//            val result = lotService.getLots()
//            val resultLotList = LotList(lotList)
//
//            if (result is Result.Success) {
//                result.data.forEach {
//                    lotList.add(Lot(it.parkingLot))
//                }
//
//                resultLotList.lotList = lotList
//                return resultLotList
//            }
//
//        } else {
//            lotDataBase.lotDao().let {
//                return Result.Success(mapper.transform(it))
//            } ?: Result.Failure(Exception("Lot not found"))
//        }
//}
//
//
//
