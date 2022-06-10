package com.example.parkingapp.lotAdapter

import android.view.View
import android.view.View.GONE
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.LotReservation
import com.example.parkingapp.Utils.AppDateFormat
import com.example.parkingapp.databinding.RecyclerItemBinding
import com.example.parkingapp.fragments.ItemOnRecyclerViewClicked

class LotHolder(private val view: View, val listener: ItemOnRecyclerViewClicked) :
    RecyclerView.ViewHolder(view) {

    private val dateFormat: AppDateFormat = AppDateFormat()
    private lateinit var binding: RecyclerItemBinding


    fun bindLot(lot: LotReservation) {
        val binding = RecyclerItemBinding.bind(view)
        binding.apply {

            parkingNumber.text = lot.parkingLot.toString()
            lot.reservationList?.firstOrNull()?.let{

                //cxambiar para mostrar la reserva que corresponde, solo si esta ocupado en el momento
       //         val endDateTime = DateFormat.getDateInstance().parse(it.endDateTimeInMillis)
                var day = dateFormat.dayFormat(it.endDateTimeInMillis.toLong())
                var monthAndYear = dateFormat.monthYearFormat(it.endDateTimeInMillis.toLong())
                var hour = dateFormat.hourFormat(it.endDateTimeInMillis.toLong())

                tvDate.text = day + " " + monthAndYear
                tvTime.text = hour
            }?: run {
                tvTime.text = "Empty"
                tvDate.visibility = GONE
            }



        }

        binding.root.setOnClickListener {
            listener.onClick(lot)
        }

    }
    }
