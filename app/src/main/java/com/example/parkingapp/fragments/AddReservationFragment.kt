package com.example.parkingapp.fragments

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import android.widget.AdapterView.*
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentAddReservationBinding
import com.example.domain.model.Reservation
import com.example.parkingapp.viewmodels.AddViewModel
import java.text.SimpleDateFormat
import java.util.*

class AddReservationFragment : Fragment() {
    private val viewModel: AddViewModel by viewModels()
    private var binding: FragmentAddReservationBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddReservationBinding.inflate(inflater, container, false)
        return binding?.root
    }

    lateinit var dateTimeWithFormatStart : String
    lateinit var dateTimeWithFormatEnd : String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddReservationBinding.bind(view)

        val spinner: Spinner? = binding?.planetsSpinner1
        val textSelected = binding?.textView
        val authorizationCode = binding?.rectangleAuthorizationCode
        val buttonAddReservation = binding?.buttonAdd

        //editText Authorization Code Hide
        val editText = binding?.etAuthorizationCodeRegistered
        editText?.isInvisible = true

        //show DateTimePickerStart
        binding?.rectangleStartTime?.setOnClickListener {
            showDateTimePickerDialog(true)
        }
        //show DateTimePickerEnd
        binding?.rectangleEndTime?.setOnClickListener {
            showDateTimePickerDialog(false)
        }
        //show Spinner
        spinner?.let {
            createSpinner(it)
        }
        //listen Spinner
        spinner?.onItemSelectedListener = object:

            OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {

            }
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }
        }

        //show input Authorization Code
        authorizationCode?.setOnClickListener() {
            binding?.textView4?.setVisibility(View.GONE)
            editText?.isInvisible = false
        }

        //SAVE button
        buttonAddReservation?.setOnClickListener{

            //Spinner value
            val itemSelected = spinner?.selectedItem.toString()
           // viewModel.itemSelectedVM = itemSelected as Int

            //save code
            val enteredCode = editText?.text?.toString()
           // viewModel.enteredCodeVM = enteredCode!!
            Toast.makeText(activity, "$itemSelected + $enteredCode", Toast.LENGTH_LONG).show()

            //save startDateTime
            val startDateTime = dateTimeWithFormatStart
           // viewModel.startDateTimeVM = startDateTime as Long

            val endDateTime = dateTimeWithFormatEnd
          //  viewModel.EndDateTimeVM = endDateTime as Long

            Toast.makeText(context, ("$itemSelected"+"$enteredCode"+
                "$startDateTime"+"$endDateTime"),Toast.LENGTH_LONG).show()

            findNavController().navigate(R.id.action_addReservationFragment_to_lotsFragment)

        }
    }

    // create Spinner
    fun createSpinner(spinner: Spinner): SpinnerAdapter {

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

    @SuppressLint("SetTextI18n")
    private fun showDateTimePickerDialog(isStartDay: Boolean)  {

        val calendar = Calendar.getInstance()
        val dateTimeSelected = calendar
        dateTimeWithFormatStart = " dd-MM-yyyy hh:mm "
        dateTimeWithFormatEnd = " dd-MM-yyyy hh:mm "

        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            dateTimeSelected.set(Calendar.YEAR, year)
            dateTimeSelected.set(Calendar.MONTH, month)
            dateTimeSelected.set(Calendar.DAY_OF_MONTH, day)

            Toast.makeText(activity, "$day/$month/$year", Toast.LENGTH_LONG).show()

            val format = " dd-MM-yyyy hh:mm "
            val sdf = SimpleDateFormat(format, Locale.UK)

            if (isStartDay == true){
                dateTimeWithFormatStart = sdf.format(dateTimeSelected.time)
            }else{
                dateTimeWithFormatEnd = sdf.format(dateTimeSelected.time)
            }

        }

        val timelistener = TimePickerDialog.OnTimeSetListener { _, hour, minutes ->
            dateTimeSelected.set(Calendar.MINUTE, minutes)
            dateTimeSelected.set(Calendar.HOUR, hour)

            Toast.makeText(activity, "$minutes/$hour", Toast.LENGTH_LONG).show()

            binding?.tvEndDateTime?.text= dateTimeWithFormatEnd
            binding?.tvStartEndTime?.text = dateTimeWithFormatStart
        }

        TimePickerDialog(
            activity, androidx.appcompat.R.style.Base_V28_Theme_AppCompat,
            timelistener,
            calendar.get(Calendar.HOUR_OF_DAY),
            calendar.get(Calendar.MINUTE),
            false
        ).show()

        DatePickerDialog(
            requireContext(),
            dateListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

    }



interface OnclickCancelReservation {
    fun onClickReservation(reservation: Reservation)
}