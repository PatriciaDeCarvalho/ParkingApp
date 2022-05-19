package com.example.parkingapp

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingapp.lotAdapter.LotAdapter
import com.example.parkingapp.lotAdapter.LotList

class ParkingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerWiew()

//        //Floating action button
        val fab: View = findViewById(R.id.floatingActionButton1)
//        //ejecuta código al presionar view
        fab.setOnClickListener {}
    }

    fun initRecyclerWiew(){
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView1)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = LotAdapter(LotList.timeList)

    }

}