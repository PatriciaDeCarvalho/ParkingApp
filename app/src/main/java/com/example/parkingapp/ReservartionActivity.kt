package com.example.parkingapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ReservartionActivity : AppCompatActivity()


{
   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_add_reservation)
   }
}

//   override fun onBackPressed() {
//      super.onBackPressed()
//      startActivity(Intent(this, ParkingActivity::class.java))
//   }



