package com.example.parkingapp.reservationAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Reservation
import com.example.parkingapp.R
import com.example.parkingapp.fragments.ItemReservationOnRecyclerViewClicked

class ReservationAdapter(
    val  reservationList:MutableList<Reservation>,
    val listener: ItemReservationOnRecyclerViewClicked) : RecyclerView.Adapter<ReservationHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationHolder {
        val layoutInflater2 = LayoutInflater.from(parent.context)

        return ReservationHolder(layoutInflater2.inflate(R.layout.recycler_lot_detail_item, parent, false), listener)
    }

    override fun onBindViewHolder(holder: ReservationHolder, position: Int) {
        val item2 = reservationList.get(position)

        holder.bindLotDetail(item2)



    }

    override fun getItemCount(): Int= reservationList.size


}