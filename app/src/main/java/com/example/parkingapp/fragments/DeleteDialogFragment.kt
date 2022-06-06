package com.example.parkingapp.fragments

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ActionMenuView
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.parkingapp.R
import com.example.parkingapp.databinding.DeleteDialogFragmentBinding
import com.example.parkingapp.databinding.FragmentLotsBinding

class DeleteDialogFragment(): DialogFragment() {
    private var binding: DeleteDialogFragmentBinding? = null

    lateinit var onDeleteClick:(String)-> Unit

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
        Toast.makeText(context, "showing mesege ", Toast.LENGTH_LONG).show()

        //Dialog ok delete
        val ok = binding?.tvOkDelete?.setOnClickListener() {
            val authorizationCode = binding?.etAuthorizationCodeEntered
            val codeText = authorizationCode?.text?.toString()
            //en caso de nulo vacio es valor por defecto
           onDeleteClick.invoke(codeText ?: "")
            dismiss()
        }

        //Dialog cancel delete
        val cancel = binding?.tvCancelDelete?.setOnClickListener(){
            dismiss()
        }
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        binding = null
        super.onDestroyView()
    }

}



