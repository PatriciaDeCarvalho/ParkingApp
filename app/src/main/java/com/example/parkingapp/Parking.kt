package com.example.parkingapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class Parking : AppCompatActivity(

)

 //class Parking :(var lotComponentsList: Int )
//Collection<LotComponents>)
{
 override fun onCreate(savedInstanceState: Bundle?) {
     super.onCreate(savedInstanceState)
     setContentView(R.layout.lot_detail)
 }

override fun onBackPressed() {
    super.onBackPressed()
    startActivity(Intent(this, MainActivity::class.java))
}
}