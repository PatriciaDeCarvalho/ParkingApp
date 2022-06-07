package com.example.parkingapp.lotAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.LotList

import com.example.parkingapp.R
import com.example.parkingapp.fragments.ItemOnRecyclerViewClicked

class LotAdapter(val lotList: LotList, val listener: ItemOnRecyclerViewClicked):
    RecyclerView.Adapter<LotHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): LotHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return LotHolder( layoutInflater.inflate(R.layout.recycler_item, parent,false), listener)
    }

    override fun onBindViewHolder(holder: LotHolder,position: Int) {
        val item = lotList.lotList.get(position)

        holder.bindLot(item)
    }

    override fun getItemCount()= lotList.lotList.size

}