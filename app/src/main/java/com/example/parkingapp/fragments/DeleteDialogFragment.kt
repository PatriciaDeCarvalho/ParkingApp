package com.example.parkingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.parkingapp.databinding.DeleteDialogFragmentBinding


class DeleteDialogFragment() : DialogFragment() {
    private var binding: DeleteDialogFragmentBinding? = null
    lateinit var onDeleteClick: (String) -> Unit

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DeleteDialogFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Dialog ok delete
         binding?.tvOkDelete?.setOnClickListener() {
            val authorizationCode = binding?.etAuthorizationCodeEntered
            val codeText = authorizationCode?.text?.toString()
          //  Toast.makeText(context, "bfb$codeText", Toast.LENGTH_LONG).show()
            dismiss()
        }

        //Dialog cancel delete
        binding?.tvCancelDelete?.setOnClickListener(){
            dismiss()
        }

    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

}



