//package com.example.parkingapp.lotAdapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import com.example.parkingapp.R
//
//class LotAdapter(private val dateTimeEnd: List<Lot>): RecyclerView.Adapter<LotHolder> (){
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LotHolder {
//    val layoutInflater = LayoutInflater.from(parent.context)
//        return LotHolder(layoutInflater.inflate(R.layout.item, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: LotHolder, position: Int) {
//        val item1 = dateTimeEnd[position]
//        holder.render(item1)
//    }
//
//    //tamaño de listado
//    override fun getItemCount(): Int {
//        return dateTimeEnd.size
//    }
//
//}

package com.example.parkingapp.lotAdapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.parkingapp.R

class LotAdapter(val lotList: List<Lot>): RecyclerView.Adapter<LotHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): LotHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        return LotHolder( layoutInflater.inflate(R.layout.item, parent,false))
    }

    override fun onBindViewHolder(holder: LotHolder,position: Int) {
        val item = lotList[position]

        holder.model(item)
    }

    override fun getItemCount()= lotList.size

}