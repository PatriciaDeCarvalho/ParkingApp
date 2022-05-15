package com.example.parkingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.parkingapp.lotAdapter.LotAdapter
import com.example.parkingapp.lotAdapter.LotList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerWiew()

//        //Floating action button
//        val fab: View = findViewById(R.id.floatingActionButton)
//        //ejecuta código al presionar view
//        fab.setOnClickListener{}
    }

    fun initRecyclerWiew(){
    val recyclerView = findViewById<RecyclerView>(R.id.recyclerView1)
    recyclerView.layoutManager = LinearLayoutManager(this)
    recyclerView.adapter = LotAdapter(LotList.dateTimeEnd)

}

}