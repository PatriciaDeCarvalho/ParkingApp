package com.example.parkingapp.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.parkingapp.R

class DeleteDialogFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var rootView: View = inflater.inflate(R.layout.delete_dialog_fragment, container, false)

      return  rootView
    }


}

//    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog =
//        AlertDialog.Builder(requireContext())
//            .setMessage(getString(R.string.order_confirmation))
//            .setPositiveButton(getString(R.string.ok)) { _,_ -> }
//            .create()
//
//    companion object {
//        const val TAG = "PurchaseConfirmationDialog"
//    }
//
//}