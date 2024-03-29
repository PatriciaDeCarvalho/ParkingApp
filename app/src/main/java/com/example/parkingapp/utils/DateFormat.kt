package com.example.parkingapp.utils

import java.text.SimpleDateFormat


class DateFormat {

    fun hourFormat(date: Long): String {
        val simpleDateFormat = SimpleDateFormat("hh:mm a")
        return simpleDateFormat.format(date)
    }
    fun dayFormat(date: Long): String {
        val simpleDateFormat = SimpleDateFormat("EEEE d")
        return simpleDateFormat.format(date)
    }
    fun monthYearFormat(date: Long): String {
        val simpleDateFormat = SimpleDateFormat("MMMM yyyy")
        return simpleDateFormat.format(date)
    }

    fun completeFormat(date: Long): String{
        val simpleDateFormat = SimpleDateFormat(" dd-MM-yyyy hh:mm ")
        return simpleDateFormat.format(date)
    }



}

