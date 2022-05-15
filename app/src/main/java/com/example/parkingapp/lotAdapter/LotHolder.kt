package com.example.parkingapp.lotAdapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingapp.R

class LotHolder(view:View) : RecyclerView.ViewHolder(view) {

    val lastDate = view.findViewById<TextView>(R.id.firstText)
    val lastTime = view.findViewById<TextView>(R.id.secondText)


    fun render(lotModel: Lot) {

        lastDate.text = lotModel.dateOfStart
        lastTime.text = lotModel.timeGetFree
    }
}