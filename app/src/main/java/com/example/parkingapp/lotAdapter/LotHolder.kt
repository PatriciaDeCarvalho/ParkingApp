package com.example.parkingapp.lotAdapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Lot
import com.example.parkingapp.databinding.RecyclerItemBinding
import com.example.parkingapp.fragments.ItemOnRecyclerViewClicked

class LotHolder(private val view: View, val listener: ItemOnRecyclerViewClicked) :
    RecyclerView.ViewHolder(view) {

    private lateinit var binding: RecyclerItemBinding


    fun bindLot(lot: Lot) {
        val binding = RecyclerItemBinding.bind(view)
        binding.apply {
            tvDate.text = lot.dateOfStart
            tvTime.text = lot.timeGetFree

        }

        binding.root.setOnClickListener {
            listener.onClick(lot)
        }

    }
    }
