package com.example.parkingapp.viewmodels

import android.app.Activity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

class LotViewModelProvider(activity: Activity) : ViewModelProvider(
    activity as ViewModelStoreOwner,
    LotViewModelFactory(activity.applicationContext)
)
