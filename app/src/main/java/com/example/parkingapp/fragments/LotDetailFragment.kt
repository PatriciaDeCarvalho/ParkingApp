package com.example.parkingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotDetailsBinding
import com.example.parkingapp.reservationAdapter.ReservationAdapter
import com.example.parkingapp.reservationAdapter.ReservationList


class LotDetailFragment : Fragment() {

    private var binding: FragmentLotDetailsBinding?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLotDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLotDetailsBinding.bind(view)

        initRecyclerWiewReservations()

        //FloatingActionButton
        binding?.floatingActionButton2?.setOnClickListener() {
            findNavController().navigate(R.id.action_lotsFragment_to_addReservationFragment)
        }
    }
        private fun initRecyclerWiewReservations() {
            val recyclerView = binding?.recyclerView2
            recyclerView?.layoutManager = LinearLayoutManager(activity)
            recyclerView?.adapter = ReservationAdapter(ReservationList.reservationList)
    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        binding = null
        super.onDestroyView()
    }


}

