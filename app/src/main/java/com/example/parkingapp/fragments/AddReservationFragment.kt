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
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentAddReservationBinding
import com.example.domain.model.Reservation
import com.example.parkingapp.Utils.AppDateFormat
import com.example.parkingapp.viewmodels.AddViewModel
import com.example.parkingapp.viewmodels.LotViewModelProvider
import java.text.SimpleDateFormat
import java.util.*

class AddReservationFragment : Fragment() {
    private val viewModel: AddViewModel by lazy {
        LotViewModelProvider(requireActivity()).get(AddViewModel::class.java)
    }
    private lateinit var binding: FragmentAddReservationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddReservationBinding.inflate(inflater, container, false)
        return binding?.root
    }
    private val formatTool = AppDateFormat()
    private  var parkingLot: Int = 0
    private lateinit var dateStart: Calendar
    private lateinit var dateEnd: Calendar
    private lateinit var authorizationCode: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddReservationBinding.bind(view)

        val spinner: Spinner? = binding?.planetsSpinner1
        val textSelected = binding?.textView
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
        spinner?.onItemSelectedListener = object :

            OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                parkingLot = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        //show input Authorization Code
        binding.rectangleAuthorizationCode.setOnClickListener(){
            binding?.textView4?.setVisibility(View.GONE)
            editText?.isInvisible = false

            authorizationCode = editText.text.toString()
        }

        //SAVE button
        buttonAddReservation?.setOnClickListener {

            viewModel.addReservation(
                Reservation(
                    "",
                    authorizationCode,
                    dateStart.timeInMillis,
                    dateEnd.timeInMillis,
                    parkingLot
                )
            )
            viewModel.successfulAdd.observe(viewLifecycleOwner) { addSuccessfuly ->
                if (addSuccessfuly) {
                    findNavController().navigate(R.id.action_addReservationFragment_to_lotsFragment)
                    Toast.makeText(context, "Added correctly", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Could not be processed", Toast.LENGTH_LONG).show()
                }
            }


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
    private fun showDateTimePickerDialog(isStartDay: Boolean) {
         // variable que contendra toda la informacion de fecha y hora
        val date = Calendar.getInstance()

        //carga la fecha
        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            date.set(Calendar.YEAR, year)
            date.set(Calendar.MONTH, month)
            date.set(Calendar.DAY_OF_MONTH, day)

            //Toast.makeText(activity, "$day/$month/$year", Toast.LENGTH_LONG).show()

            if (isStartDay == true) {
                dateStart = date
            } else {
                dateEnd = date
            }

        }
        //carga la hora, esta es la ultima funcion en ejecutarse
        val timelistener = TimePickerDialog.OnTimeSetListener { _, hour, minutes ->
            date.set(Calendar.MINUTE, minutes)
            date.set(Calendar.HOUR, hour)

            if (isStartDay == true) {
                dateStart = date
                binding.tvStartEndTime.text = formatTool.completeFormat(dateStart.timeInMillis)

            } else {
                dateEnd = date
                binding.tvEndDateTime.text = formatTool.completeFormat(dateStart.timeInMillis)
            }

            /*Toast.makeText(activity, "$minutes/$hour", Toast.LENGTH_LONG).show()

            binding?.tvEndDateTime?.text = dateTimeWithFormatEnd
            binding?.tvStartEndTime?.text = dateTimeWithFormatStart*/
        }

    // Las siguientes dos funciones muestran los dialogos con la hfecha y hora actuales

        TimePickerDialog(
            activity, androidx.appcompat.R.style.Base_V28_Theme_AppCompat,
            timelistener,
            date.get(Calendar.HOUR_OF_DAY),
            date.get(Calendar.MINUTE),
            false
        ).show()

        DatePickerDialog(
            requireContext(),
            dateListener,
            date.get(Calendar.YEAR),
            date.get(Calendar.MONTH),
            date.get(Calendar.DAY_OF_MONTH)
        ).show()
    }

}


interface OnclickCancelReservation {
    fun onClickReservation(reservation: Reservation)
}