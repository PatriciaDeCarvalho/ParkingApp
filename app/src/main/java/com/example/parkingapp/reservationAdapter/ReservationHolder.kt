package com.example.parkingapp.reservationAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingapp.databinding.RecyclerLotDetailItemBinding
import com.example.parkingapp.fragments.ItemReservationOnRecyclerViewClicked

class ReservationHolder(
    private val view: View,
    val listener: ItemReservationOnRecyclerViewClicked
    ) :RecyclerView.ViewHolder(view) {

    private lateinit var binding: RecyclerLotDetailItemBinding

    fun bindLotDetail(lotReservations: Reservation) {
        val binding = RecyclerLotDetailItemBinding.bind(view)

        binding.apply {
            tvStartDay.text = lotReservations.starDateTimeInMillis
            tvStartMonthYear.text = lotReservations.starDateTimeInMillis
            tvStartTime.text = lotReservations.starDateTimeInMillis
            tvEndDay.text = lotReservations.endDateTimeInMillis
            tvEndMonthYear.text = lotReservations.endDateTimeInMillis
            tvEndTime.text = lotReservations.endDateTimeInMillis

        }

        binding.bnDelete.setOnClickListener {
            listener.onClickReservation(lotReservations)
        }

    }
}

