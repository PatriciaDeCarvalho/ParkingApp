package com.example.parkingapp.reservationAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingapp.R

class ReservationAdapter(val reservationList:List<Reservation>) : RecyclerView.Adapter<ReservationHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationHolder {
        val layoutInflater2 = LayoutInflater.from(parent.context)
        return ReservationHolder(layoutInflater2.inflate(R.layout.lot_detail, parent, false))
    }

    override fun onBindViewHolder(holder: ReservationHolder, position: Int) {
        val item2 = reservationList[position]
        holder.model2(item2)

    }

    override fun getItemCount(): Int {
        return reservationList.size

    }
}