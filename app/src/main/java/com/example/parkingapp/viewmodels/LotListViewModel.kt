package com.example.parkingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.model.Lot

class LotListViewModel : ViewModel() {

    val lotList: MutableLiveData<List<Lot>> by lazy {
        MutableLiveData<List<Lot>>().apply {
            value = loadLots()
        }
    }

    fun getMyLotList(): LiveData<List<Lot>> {
        return lotList
    }


    private fun loadLots() = mutableListOf<Lot>(
        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "15:00"),

        Lot(
            dateOfStart = "Friday 22 May ",
            timeGetFree = "10:30"),

        Lot(
            dateOfStart = "Friday 22 May",
            timeGetFree = "11:10"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:30"),

        Lot(
            dateOfStart = "Sunday 24 May",
            timeGetFree = "10:30"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "14:40"),

        Lot(
            dateOfStart = "Friday 22 May",
            timeGetFree = "12:30"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Monday 25 May",
            timeGetFree = "12:40"),

        Lot(
            dateOfStart = "Saturday 13 May",
            timeGetFree = "12:ZZZZZ")
    )


}


