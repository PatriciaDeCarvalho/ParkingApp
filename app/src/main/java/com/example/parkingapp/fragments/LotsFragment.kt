
package com.example.parkingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.domain.model.LotReservation
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotsBinding
import com.example.parkingapp.lotAdapter.LotAdapter
import com.example.parkingapp.viewmodels.LotViewModel
import com.example.parkingapp.viewmodels.LotViewModelProvider


class LotsFragment : Fragment(), LotsFragment.ItemOnRecyclerViewClicked {

    private var binding: FragmentLotsBinding? = null
    private val viewModel: LotViewModel by lazy {
        LotViewModelProvider(requireActivity()).get(LotViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLotsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel.lotProgress.observe(viewLifecycleOwner) {
            binding?.tvBusy?.text = it.lotBusy.toString() + " Busy"
            binding?.tvFee?.text = it.lotFree.toString() + " Free"
            binding?.progressBar?.progress = it.lotBusy
            binding?.progressBar?.max = it.lotBusy + it.lotFree
        }
        viewModel.lots.observe(viewLifecycleOwner) { lotList ->
            initRecyclerViewLots(lotList)
        }
        viewModel.reservations.observe(viewLifecycleOwner) { reservationList ->
            //   Toast.makeText(context, reservationList.reservationList.first().authorizationCode,Toast.LENGTH_LONG ).show()
        }


  //      viewModel.loadData()

        //FloatingActionButton
        binding?.floatingActionButton1?.setOnClickListener() {
            findNavController().navigate(R.id.action_lotsFragment_to_addReservationFragment)
        }

    }

    //Recycler View
    private fun initRecyclerViewLots(lotList: List<LotReservation>) {

        binding?.rvLots?.apply {
            adapter = LotAdapter(lotList, this@LotsFragment)
        }

    }


    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        binding = null
        super.onDestroyView()
    }

    override fun onClick(lot: LotReservation) {
        Toast.makeText(context, lot.parkingLot.toString(), Toast.LENGTH_LONG).show()

        val bundle = Bundle()
        bundle.putSerializable("objectLot", lot)
        //send to next fragment
        findNavController().navigate(
            R.id.action_lotsFragment_to_lotDetailFragment,
            bundle
        )
    }

}

interface ItemOnRecyclerViewClicked {
    fun onClick(lot: LotReservation)


}

