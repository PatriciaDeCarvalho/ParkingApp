package com.example.parkingapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotsBinding
import com.example.parkingapp.lotAdapter.Lot
import com.example.parkingapp.lotAdapter.LotAdapter
import com.example.parkingapp.lotAdapter.LotList


class LotsFragment : Fragment(), ItemOnRecyclerViewClicked {

    private var binding : FragmentLotsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLotsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerViewLots()

        //FloatingActionButton
        binding?.floatingActionButton1?.setOnClickListener() {
            findNavController().navigate(R.id.action_lotsFragment_to_addReservationFragment)

        }
    }
    //Recycler View
    private  fun initRecyclerViewLots(){
        binding?.rvLots?.apply {
            adapter = LotAdapter(LotList.timeList, this@LotsFragment)
        }

    }
    override fun onClick(lot: Lot) {
        Toast.makeText(context, lot.dateOfStart, Toast.LENGTH_LONG).show()
        findNavController().navigate(LotsFragmentDirections.actionLotsFragmentToLotDetailFragment(lot))

        //findNavController().navigate(R.id.action_lotsFragment_to_lotDetailFragment)
//        NavHostFragment.findNavController(this).navigate(
//            FindUsMapFragmentDirections.goToFindUsBottomSheet(
//                channelInfoArray.toTypedArray(),
//                completeChannel,
//                channelType.channelName
//            )
//        )

    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        binding = null
        super.onDestroyView()
    }

}

interface ItemOnRecyclerViewClicked {
    fun onClick(lot: Lot)
}
