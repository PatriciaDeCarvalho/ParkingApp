package com.example.parkingapp.reservationAdapter

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingapp.R
import com.example.parkingapp.databinding.ItemBinding
import com.example.parkingapp.databinding.LotDetailBinding

class ReservationHolder(view: View) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: LotDetailBinding

    val dayStart = binding.textDayStar
    val monthYearStar = binding.textMontYearStar
    val timeStar = binding.textTimeStar

    val dayEnd = binding.textDayEnd
    val monthYearEnd = binding.textMontYearEnd
    val timeEnd = binding.textTimeEnd

    val buttonCancel = binding.buttonCard

    fun model2(reservationModel: Reservation) {

        dayStart.text = reservationModel.starDateTimeInMillis
        monthYearStar.text = reservationModel.starDateTimeInMillis
        timeStar.text = reservationModel.starDateTimeInMillis

        dayEnd.text = reservationModel.endDateTimeInMillis
        monthYearEnd.text = reservationModel.endDateTimeInMillis
        timeEnd.text = reservationModel.endDateTimeInMillis


    }
}