package com.example.parkingapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.repositories.LotRepositoryImpl
import com.example.domain.model.Lot
import com.example.domain.repositories.LotRepository
import com.example.domain.usecases.GetLotListUseCase

import kotlinx.coroutines.launch

class LotViewModel( private val getLotListUseCase : GetLotListUseCase) : ViewModel() {
    private val _lots = MutableLiveData<List<Lot>>()
    val lots: LiveData<List<Lot>> = _lots

    fun loadLots() = viewModelScope.launch {
        val lotResponse = getLotListUseCase.getLots()
        _lots.postValue(lotResponse)
    }






    }




