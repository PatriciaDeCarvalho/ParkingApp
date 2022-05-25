package com.example.parkingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotDetailsBinding
import com.example.parkingapp.lotAdapter.Lot
import com.example.parkingapp.reservationAdapter.Reservation
import com.example.parkingapp.reservationAdapter.ReservationAdapter
import com.example.parkingapp.viewmodels.ReservationListViewModel


class LotDetailFragment : Fragment(), ItemReservationOnRecyclerViewClicked {

    private var binding: FragmentLotDetailsBinding? = null
    private val viewModel: ReservationListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.reservationList.observe(viewLifecycleOwner){ reservationList ->
            initRecyclerWiewReservations(reservationList)
        }

        binding = FragmentLotDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//       binding = FragmentLotDetailsBinding.bind(view)
        Toast.makeText(context, "llego bien", Toast.LENGTH_LONG).show()




        //FloatingActionButton
        binding?.floatingActionButton2?.setOnClickListener() {
            findNavController().navigate(R.id.action_lotsFragment_to_addReservationFragment)
        }
    }

    //RecyclerView
    private fun initRecyclerWiewReservations(listR : List<Reservation>) {

        binding?.rvReservations?.apply {

            adapter = ReservationAdapter(listR, this@LotDetailFragment)
        }

    }


    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        binding = null
        super.onDestroyView()
    }

    override fun onClick(reservation: Reservation) {
        Toast.makeText(activity, "probando:"+reservation.parkingLot, Toast.LENGTH_SHORT).show()

    }


}
interface ItemReservationOnRecyclerViewClicked{
   fun onClick(reservation: Reservation)
}





//----------------------------------------------------------------
/*package com.example.parkingapp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotDetailsBinding
import com.example.parkingapp.reservationAdapter.ReservationAdapter
import com.example.parkingapp.viewmodels.ReservationList


class LotDetailFragment : Fragment() {

    private var binding: FragmentLotDetailsBinding?=null
    private val args: LotDetailFragmentArgs by navArgs()

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

        //var myLotSelected = arguments?.getString("item")
        val lot =  args.item
        Toast.makeText(context,lot.dateOfStart, Toast.LENGTH_LONG ).show()

        //TODO aqui revisar el log y corregir asi como lo hicimos en LotsFragment
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


}*/

