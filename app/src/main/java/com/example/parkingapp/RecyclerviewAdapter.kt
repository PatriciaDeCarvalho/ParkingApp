/*package com.example.parkingapp

import android.view.View
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class RecyclerviewAdapter(private val mList: List<Lot>, private val onClick: (Lot) -> Unit :
RecyclerView.Adapter<RecyclerviewAdapter.LotViewHolder>() {

    class LotViewHolder(itemView: View, val onClick: (Lot) -> Unit) :
            RecyclerView.ViewHolder(itemView) {
                private val lotTextView: TextView = itemView.findViewById(R.id.lot_text)
        private  var currentLot: Lot? = null

    init {
        itemView.setOnClickListener {
            currentLot?.let {
                onClick(it)
            }
        }
    }

       fun lotInfo(lot: Lot) {
           currentLot = lot
           lotTextView.text = lot.parkingLot
       }
    }

}
*/