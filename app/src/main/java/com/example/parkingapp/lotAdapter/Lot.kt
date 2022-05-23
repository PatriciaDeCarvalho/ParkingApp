package com.example.parkingapp.lotAdapter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Lot (
    val dateOfStart:String,
    val timeGetFree:String): Parcelable