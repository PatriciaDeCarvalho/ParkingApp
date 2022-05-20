package com.example.parkingapp.ReservationAdapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingapp.R
import com.example.parkingapp.Reservation

class ReservationHolder(view: View) : RecyclerView.ViewHolder(view) {

    val starDateTime = view.findViewById<TextView>(R.id.text_start)
    val endDateTime = view.findViewById<TextView>(R.id.text_end)
    val buttonCard:Button = view.findViewById(R.id.button_card)

    fun render2(reservationModel: Reservation) {

        starDateTime.text = reservationModel.starDateTimeInMillis
        endDateTime.text = reservationModel.endDateTimeInMillis

    }
}