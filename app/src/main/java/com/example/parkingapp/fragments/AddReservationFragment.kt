package com.example.parkingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.*
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentAddReservationBinding
import com.example.parkingapp.DatePickerFragment

class AddReservationFragment : Fragment(R.layout.fragment_add_reservation) {

    lateinit var binding: FragmentAddReservationBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddReservationBinding.bind(view)

        val spinnerView = binding.planetsSpinner1
        val rectangleStartTime = binding.rectangleStartTime
        val rectangleEndTime = binding.rectangleEndTime
        val authorizationCode = binding.rectangleAuthorizationCode
        val buttonAddReservation = binding.buttonAdd
        val spinner: Spinner = spinnerView

        spinnerCreate(spinner)
     //   datePicker()

    }


    fun spinnerCreate(spinner: Spinner): SpinnerAdapter {

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireActivity(), R.array.lotsSpinner,
            android.R.layout.simple_spinner_item

        ).also { adapter ->

            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

            // Apply the adapter to the spinner
            spinner.adapter = adapter
            return spinner.adapter
        }
/*fun datePicker(){


    binding apply {
        rectangleStartTime.setOnClickListener()

        //new instance dataPickerFragment
        val datePickerFragment = DatePickerFragment()
        val supportFragmentManager = requireActivity().supportFragmentManager

        supportFragmentManager.setFragmentResultListener("REQUEST_KEY",viewLifecycleOwner)
    }
    resultKey, bundle -> if (resultKey == "REQUEST_KEY"){
        val date = bundle.getString("SELECTED_DATE")
        tvSelectedDate.text = date
    }
}*/
    }


//    fun saveReservation(buttonAddReservation) {
//        buttonAddReservation.SetOfCleanListener
//    }

}