package com.example.parkingapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //ir a actividad 2
        //val recyclerView1 = null
        //recyclerView1.setOnClickListener{startActivity(Intent(this, Parking::class.java))}

        //Floating action button
        val fab: View = findViewById(R.id.floatingActionButton)
        //ejecuta código al presionar view
        fab.setOnClickListener{}



    }



}