package com.example.parkingapp.lotAdapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotsBinding
import com.example.parkingapp.databinding.ItemBinding

class LotHolder(view:View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ItemBinding


    val lastDate = binding.firstText
    val lastTime = binding.secondText


    fun model(lotModel: Lot) {

        lastDate.text = lotModel.dateOfStart
        lastTime.text = lotModel.timeGetFree
    }
}