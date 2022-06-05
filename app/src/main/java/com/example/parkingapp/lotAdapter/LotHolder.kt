package com.example.parkingapp.lotAdapter

import android.view.View
import android.view.View.GONE
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Lot
import com.example.parkingapp.databinding.RecyclerItemBinding
import com.example.parkingapp.fragments.ItemOnRecyclerViewClicked
import java.text.SimpleDateFormat
import java.util.*

class LotHolder(private val view: View, val listener: ItemOnRecyclerViewClicked) :
    RecyclerView.ViewHolder(view) {

    private lateinit var binding: RecyclerItemBinding


    fun bindLot(lot: Lot) {
        val binding = RecyclerItemBinding.bind(view)
        binding.apply {

            parkingNumber.text = lot.parkingLot.toString()
            lot.reservationList.firstOrNull()?.let{

                //cxambiar para mostrar la reserva que corresponde, solo si esta ocupado en el momento
                val endDateTime = Date(it.endDateTimeInMillis)

                tvDate.text = SimpleDateFormat.getDateInstance().format(endDateTime)
                tvTime.text = SimpleDateFormat.getTimeInstance().format(endDateTime)
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
