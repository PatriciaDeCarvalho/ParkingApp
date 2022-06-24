
package com.example.parkingapp.fragments

import android.annotation.SuppressLint
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


class LotsFragment : Fragment(), ItemOnRecyclerViewClicked {

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

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onResume()

        viewModel.lotProgress.observe(viewLifecycleOwner) {
            binding?.tvBusy?.text = it.lotBusy.toString() + getString(R.string.Busyy)
            binding?.tvFee?.text = it.lotFree.toString() + getString(R.string.Freee)
            binding?.progressBar?.progress = it.lotBusy
            binding?.progressBar?.max = it.lotBusy + it.lotFree

        }
        viewModel.lots.observe(viewLifecycleOwner) { lotList ->
            initRecyclerViewLots(lotList)
        }



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
        binding = null
        super.onDestroyView()
    }

    override fun onClick(lot: LotReservation) {
        Toast.makeText(context, lot.parkingLot.toString(), Toast.LENGTH_LONG).show()

        val bundle = Bundle()
        bundle.putSerializable("objectLot", lot)
        findNavController().navigate(
            R.id.action_lotsFragment_to_lotDetailFragment,
            bundle
        )
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadData()
    }

}

interface ItemOnRecyclerViewClicked {
    fun onClick(lot: LotReservation)

}

