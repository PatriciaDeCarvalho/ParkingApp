package com.example.parkingapp.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.domain.model.Lot
import com.example.domain.model.LotList
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


        viewModel.lots.observe(viewLifecycleOwner) { lotList ->
            initRecyclerViewLots(lotList)
        }

        binding = FragmentLotsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.loadLots()

        //FloatingActionButton
        binding?.floatingActionButton1?.setOnClickListener() {
            findNavController().navigate(R.id.action_lotsFragment_to_addReservationFragment)
        }
//        var tvBusy = binding.tvBusy.text
//        var tvFree = binding.tvFee.text
//        var parkingLotsAvailable = viewModel.lotResponse.size
//        viewModel.lotResponse.forEach (){
//                if (lista.reservation,isEmpty()){
//                parkingLotsAvailable --
//            }
//            }

    }
    //Recycler View
    private fun initRecyclerViewLots(lotList: LotList) {

        binding?.rvLots?.apply {
            adapter = LotAdapter(lotList, this@LotsFragment)
        }

    }


    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        binding = null
        super.onDestroyView()
    }

    override fun onClick(lot: Lot) {
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
    fun onClick(lot: com.example.domain.model.Lot)


}

