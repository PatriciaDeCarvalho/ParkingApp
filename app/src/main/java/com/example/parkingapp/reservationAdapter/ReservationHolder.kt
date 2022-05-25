package com.example.parkingapp.reservationAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingapp.databinding.RecyclerItemBinding
import com.example.parkingapp.databinding.RecyclerLotDetailItemBinding
import com.example.parkingapp.fragments.ItemOnRecyclerViewClicked
import com.example.parkingapp.fragments.ItemReservationOnRecyclerViewClicked
import com.example.parkingapp.lotAdapter.Lot

class ReservationHolder(
    private val view: View,
    val listener: ItemReservationOnRecyclerViewClicked
    ) :RecyclerView.ViewHolder(view) {

    private lateinit var binding: RecyclerLotDetailItemBinding

    fun bindLotDetail(lotReservations: Reservation) {
        val binding = RecyclerLotDetailItemBinding.bind(view)

        binding.apply {
            tvSatrtDay.text = lotReservations.starDateTimeInMillis
            tvStartMonthYear.text = lotReservations.starDateTimeInMillis
            tvStartTime.text = lotReservations.starDateTimeInMillis
            tvEndDay.text = lotReservations.endDateTimeInMillis
            tvEndMonthYear.text = lotReservations.endDateTimeInMillis
            tvEndTime.text = lotReservations.endDateTimeInMillis

        }
        binding.root.setOnClickListener {
            listener.onClick(lotReservations)
        }

    }
}

