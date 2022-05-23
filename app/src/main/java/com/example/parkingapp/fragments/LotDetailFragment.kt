package com.example.parkingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parkingapp.R
import com.example.parkingapp.reservationAdapter.ReservationAdapter
import com.example.parkingapp.reservationAdapter.ReservationList
import com.example.parkingapp.databinding.FragmentLotDetailsBinding



class LotDetailFragment : Fragment(R.layout.fragment_lot_details) {


    lateinit var binding: FragmentLotDetailsBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLotDetailsBinding.bind(view)

        initRecyclerWiewReservations()

        //FloatingActionButton
        binding.floatingActionButton2.setOnClickListener() {
            findNavController().navigate(R.id.action_lotsFragment_to_addReservationFragment)
        }
    }
        private fun initRecyclerWiewReservations() {
            val recyclerView = binding.recyclerView2
            recyclerView.layoutManager = LinearLayoutManager(activity)
            recyclerView.adapter = ReservationAdapter(ReservationList.reservationList)


    }
}