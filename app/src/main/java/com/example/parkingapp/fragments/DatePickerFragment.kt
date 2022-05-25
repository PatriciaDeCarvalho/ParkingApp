package com.example.parkingapp.fragments

import android.app.DatePickerDialog
import android.app.Dialog

import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.text.SimpleDateFormat
import java.util.*

class DatePickerFragment:DialogFragment(), DatePickerDialog.OnDateSetListener {


    private val calendar = Calendar.getInstance()

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(requireActivity(), this, year, month, day).show()
    }


    override fun onDateSet(p0: DatePicker?, year: Int, month: Int, day: Int) {

        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, day)

        val selectedData = SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH).format(calendar.time)
    }
}