package com.example.parkingapp.lotAdapter

import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.LotReservation
import com.example.parkingapp.Utils.AppDateFormat
import com.example.parkingapp.databinding.RecyclerItemBinding
import com.example.parkingapp.fragments.ItemOnRecyclerViewClicked

class LotHolder(private val view: View, val listener: ItemOnRecyclerViewClicked) :
    RecyclerView.ViewHolder(view) {

    private val dateFormat: AppDateFormat = AppDateFormat()



    fun bindLot(lot: LotReservation) {
        val binding = RecyclerItemBinding.bind(view)
        binding.apply {

            parkingNumber.text = lot.parkingLot.toString()
            lot.reswervationList?.firstOrNull()?.let{
                tvDate.visibility = VISIBLE

                val day = dateFormat.dayFormat(it.endDateTimeInMillis.toLong())
                val monthAndYear = dateFormat.monthYearFormat(it.endDateTimeInMillis.toLong())
                val hour = dateFormat.hourFormat(it.endDateTimeInMillis.toLong())

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
