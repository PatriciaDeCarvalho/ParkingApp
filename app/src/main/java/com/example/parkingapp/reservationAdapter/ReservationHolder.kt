package com.example.parkingapp.reservationAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Reservation
import com.example.parkingapp.Utils.AppDateFormat
import com.example.parkingapp.databinding.RecyclerLotDetailItemBinding


class ReservationHolder(

    private val view: View
//    val listener: ItemReservationOnRecyclerViewClicked
    ) :RecyclerView.ViewHolder(view) {

    private val  dateFormat: AppDateFormat = AppDateFormat()

    private lateinit var binding: RecyclerLotDetailItemBinding

    fun bindLotDetail(
        lotReservations: Reservation,
        listener: (Reservation, Int) -> Unit,
        position: Int
    ) {
         binding = RecyclerLotDetailItemBinding.bind(view)

        binding.apply {
            tvStartDay.text = dateFormat.dayFormat(lotReservations.starDateTimeInMillis.toLong())
            tvStartMonthYear.text = dateFormat.monthYearFormat(lotReservations.starDateTimeInMillis.toLong())
            tvStartTime.text = dateFormat.hourFormat(lotReservations.starDateTimeInMillis.toLong())
            tvEndDay.text = dateFormat.dayFormat(lotReservations.starDateTimeInMillis.toLong())
            tvEndMonthYear.text = dateFormat.monthYearFormat(lotReservations.starDateTimeInMillis.toLong())
            tvEndTime.text = dateFormat.hourFormat(lotReservations.starDateTimeInMillis.toLong())

        }

        binding.bnDelete.setOnClickListener {
        listener(lotReservations, position)
        }
    }
}
