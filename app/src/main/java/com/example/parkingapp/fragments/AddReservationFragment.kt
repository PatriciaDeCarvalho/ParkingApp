package com.example.parkingapp.fragments

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
import com.example.parkingapp.Utils.DateReservation
import com.example.parkingapp.viewmodels.AddViewModel
import com.example.parkingapp.viewmodels.LotViewModelProvider
import java.util.*

class AddReservationFragment : Fragment() {
    private val viewModel: AddViewModel by lazy {
        LotViewModelProvider(requireActivity()).get(AddViewModel::class.java)
    }
    private lateinit var binding: FragmentAddReservationBinding
    private var initialDate = DateReservation()
    private var finalDate = DateReservation()
    private var parkingLot: Int = -1
    private var authorizationCode: String = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddReservationBinding.inflate(inflater, container, false)
        return binding.root
    }

    private val formatTool = AppDateFormat()
    private lateinit var dateStart: Calendar
    private lateinit var dateEnd: Calendar
    private var dia: String = "Prueba"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentAddReservationBinding.bind(view)
        val spinner: Spinner = binding.planetsSpinner1
        val buttonAddReservation = binding.buttonAdd

        //editText Authorization Code Hide
        val editText = binding.etAuthorizationCodeRegistered
        editText.isInvisible = true

        //show DateTimePickerStart
        binding.rectangleStartTime.setOnClickListener {
            showDateTimePickerDialog(true, initialDate)
        }
        //show DateTimePickerEnd
        binding.rectangleEndTime.setOnClickListener {
            showDateTimePickerDialog(false, finalDate)
        }
        //show Spinner
        spinner.let {
            createSpinner(it)
        }
        //listen Spinner
        spinner.onItemSelectedListener = object :

            OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                parkingLot = position - 1
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

        //show input Authorization Code
        binding.rectangleAuthorizationCode.setOnClickListener() {
            binding.textView4.setVisibility(View.GONE)
            editText.isInvisible = false


        }

        //SAVE button
        buttonAddReservation.setOnClickListener {
            authorizationCode = editText.text.toString()

            if (
                authorizationCode != "" &&
                parkingLot > -1 &&
                this::dateStart.isInitialized &&
                this::dateEnd.isInitialized
            ) {

                viewModel.addReservation(
                    Reservation(
                        "",
                        authorizationCode,
                        dateStart.timeInMillis,
                        dateEnd.timeInMillis,
                        parkingLot
                    )
                )

            } else {
                Toast.makeText(context, "You must complete all fields", Toast.LENGTH_LONG).show()

            }

            viewModel.successfulAdd.observe(viewLifecycleOwner) { addSuccessfuly ->
                if (addSuccessfuly) {

                    Toast.makeText(context, "The reservation has been successfully added", Toast.LENGTH_LONG).show()
                    findNavController().popBackStack()


                } else {
                    Toast.makeText(context, "Could not be processed", Toast.LENGTH_LONG).show()

                    findNavController().popBackStack()

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


    private fun showDateTimePickerDialog(isStartDay: Boolean, dateInMillis: DateReservation) {

        val date = Calendar.getInstance()

        val dateListener = DatePickerDialog.OnDateSetListener { _, year, month, day ->
            date.set(Calendar.YEAR, year)
            date.set(Calendar.MONTH, month)
            date.set(Calendar.DAY_OF_MONTH, day)


            if (isStartDay) {
                dateStart = date
            } else {
                dateEnd = date
            }

        }

        val timelistener = TimePickerDialog.OnTimeSetListener { _, hour, minutes ->
            date.set(Calendar.MINUTE, minutes)
            date.set(Calendar.HOUR, hour)

            if (isStartDay) {
                dateStart = date
                binding.tvStartEndTime.text = formatTool.completeFormat(dateStart.timeInMillis)

            } else {
                dateEnd = date
                binding.tvEndDateTime.text = formatTool.completeFormat(dateEnd.timeInMillis)
            }
            dateInMillis.dateInMilliseconds = date.timeInMillis

        }

        TimePickerDialog(
            activity, androidx.appcompat.R.style.Base_V28_Theme_AppCompat,
            timelistener,
            date.get(Calendar.HOUR_OF_DAY),
            date.get(Calendar.MINUTE),
            false
        ).show()

        val datePicker = DatePickerDialog(
            requireContext(),
            dateListener,
            date.get(Calendar.YEAR),
            date.get(Calendar.MONTH),
            date.get(Calendar.DAY_OF_MONTH)
        )
        datePicker.datePicker.minDate = System.currentTimeMillis()
        datePicker.show()
    }

}


