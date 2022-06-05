package com.example.parkingapp.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.data.repositories.LotRepositoryImpl
import com.example.data.repositories.service.LotService
import com.example.domain.usecases.GetLotListUseCase

class LotViewModelFactory(private val context: Context) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass == LotViewModel::class.java){
            return LotViewModel(GetLotListUseCase().apply {
                repository= LotRepositoryImpl().apply {
                    lotService = LotService()
                }
            }) as T
        }
        return super.create(modelClass)
    }
}