package com.example.parkingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotsBinding
import com.example.parkingapp.lotAdapter.LotAdapter
import com.example.parkingapp.lotAdapter.LotList


class LotsFragment : Fragment(R.layout.fragment_lots) {

    private lateinit var binding : FragmentLotsBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentLotsBinding.bind(view)

        initRecyclerWiewLots()

        //FloatingActionButton
        binding.floatingActionButton1.setOnClickListener() {
            findNavController().navigate(R.id.action_lotsFragment_to_addReservationFragment)

        //must to select one recyclerview item
        //must to get id Lot and Show all reservations with that Id in LotDetailFragment, order it before

        }
    }
    //Recycler View
    private  fun initRecyclerWiewLots(){
        val recyclerView = binding.recyclerView1
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = LotAdapter(LotList.timeList)

    }


}
