package com.example.parkingapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingapp.R.layout.activity_lot_details
import com.example.parkingapp.ReservationAdapter.ReservationAdapter
import com.example.parkingapp.ReservationAdapter.ReservationList

class LotDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lot_details)
        initRecyclerView2()
    }

     private fun initRecyclerView2(){
        val recyclerView2 = findViewById<RecyclerView>(R.id.recyclerView2)
        recyclerView2.layoutManager = LinearLayoutManager(this)
        recyclerView2.adapter = ReservationAdapter(ReservationList.reservationList)
    }
}