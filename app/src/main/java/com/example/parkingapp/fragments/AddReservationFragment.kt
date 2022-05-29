package com.example.parkingapp.fragments

import android.app.ActionBar
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentAddReservationBinding
import com.example.parkingapp.reservationAdapter.Reservation
import java.util.*

class AddReservationFragment : Fragment(), OnclickCancelReservation {

    private var binding: FragmentAddReservationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddReservationBinding.inflate(inflater, container, false)
        return binding?.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddReservationBinding.bind(view)

        val spinnerView = binding?.planetsSpinner1
        val authorizationCode = binding?.rectangleAuthorizationCode
        val buttonAddReservation = binding?.buttonAdd
        val spinner: Spinner? = spinnerView
        //editText Authorization Code Hide
        val editText = binding?.etAuthorizationCodeRegistered
        editText?.isInvisible = true


        binding?.rectangleStartTime?.setOnClickListener {
            showDateTimePickerDialog()
        }

        binding?.rectangleEndTime?.setOnClickListener {
            showDateTimePickerDialog()
        }

        spinner?.let {
            showSpinner(it)
        }

        //Authorization Code
        authorizationCode?.setOnClickListener() {

            binding?.textView4?.setVisibility(View.GONE)
            editText?.isInvisible = false

        }

        val enteredCode = editText?.text?.toString()


      //  onClickReservation(Reservation)
    }

    fun showSpinner(spinner: Spinner): SpinnerAdapter {

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


    }

    private fun showDateTimePickerDialog() {

        val calendar = Calendar.getInstance()

        val timelistener = TimePickerDialog.OnTimeSetListener { _, hour, minutes ->

            //save information instead of toast
            Toast.makeText(
                activity, "$hour:$minutes", Toast.LENGTH_LONG
            ).show()
        }

        TimePickerDialog(
            activity, androidx.appcompat.R.style.Base_V28_Theme_AppCompat,
            timelistener,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        ).show()

        val dateTimeListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            Toast.makeText(
                activity, "$day/$month/$year", Toast.LENGTH_LONG
            ).show()

        }

        DatePickerDialog(
            requireContext(),
            dateTimeListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    //Save reservation
    override fun onClickReservation(reservation: Reservation) {


   //spinner number selected
        //date time start
        //date time end
        //authorization Code

        //add all in array reservations add lot
    }


}

interface OnclickCancelReservation {
    fun onClickReservation(reservation: Reservation)
}