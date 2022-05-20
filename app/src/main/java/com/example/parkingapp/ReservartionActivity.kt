package com.example.parkingapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class ReservartionActivity : AppCompatActivity() {

   lateinit var options: Spinner
   lateinit var textSpinner: EditText


   override fun onCreate(savedInstanceState: Bundle?) {
      super.onCreate(savedInstanceState)
      setContentView(R.layout.activity_add_reservation)

      //acces to spinner
      options = findViewById(R.id.planets_spinner1)
      //textSpinner = findViewById(R.id.textView)

      //acces to array
      val spinnerArray = resources.getStringArray(R.array.lotsSpinner)


      // spinner Adapter
      val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, spinnerArray)
      options.adapter = spinnerAdapter

      options.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {

         override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            Toast.makeText(applicationContext, options.toString(), Toast.LENGTH_SHORT).show()

         }

         override fun onNothingSelected(parent: AdapterView<*>) {


         }
      }
   }
}




