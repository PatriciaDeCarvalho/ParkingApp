package com.example.parkingapp.reservationAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Reservation
import com.example.parkingapp.Utils.AppDateFormat
import com.example.parkingapp.databinding.RecyclerLotDetailItemBinding
import com.example.parkingapp.fragments.ItemReservationOnRecyclerViewClicked

class ReservationHolder(

    private val view: View,
    val listener: ItemReservationOnRecyclerViewClicked
    ) :RecyclerView.ViewHolder(view) {

    private val  dateFormat: AppDateFormat = AppDateFormat()

    private lateinit var binding: RecyclerLotDetailItemBinding

    fun bindLotDetail(lotReservations: Reservation) {
         binding = RecyclerLotDetailItemBinding.bind(view)

        binding.apply {
            tvStartDay.text = dateFormat.dayFormat(lotReservations.starDateTimeInMillis)
            tvStartMonthYear.text = dateFormat.monthYearFormat(lotReservations.starDateTimeInMillis)
            tvStartTime.text = dateFormat.hourFormat(lotReservations.starDateTimeInMillis)
            tvEndDay.text = dateFormat.dayFormat(lotReservations.starDateTimeInMillis)
            tvEndMonthYear.text = dateFormat.monthYearFormat(lotReservations.starDateTimeInMillis)
            tvEndTime.text = dateFormat.hourFormat(lotReservations.starDateTimeInMillis)

        }

        binding.bnDelete.setOnClickListener {
            listener.onClickReservation(lotReservations)
        }
    }
}
