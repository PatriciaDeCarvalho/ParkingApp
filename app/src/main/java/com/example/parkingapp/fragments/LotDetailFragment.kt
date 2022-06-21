package com.example.parkingapp.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.ContentInfo
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Lot
import com.example.domain.model.LotReservation
import com.example.domain.model.Reservation
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotDetailsBinding
import com.example.parkingapp.reservationAdapter.ReservationAdapter
import com.example.parkingapp.viewmodels.LotViewModel
import com.example.parkingapp.viewmodels.LotViewModelProvider
import com.example.parkingapp.viewmodels.ReservationViewModel


class LotDetailFragment : Fragment() {
    private var lot: LotReservation? = null
    private var binding: FragmentLotDetailsBinding? = null
    private val viewModel: ReservationViewModel by lazy {
        LotViewModelProvider(requireActivity()).get(ReservationViewModel::class.java)
    }

    private val lotViewModel: LotViewModel by lazy {
        LotViewModelProvider(requireActivity()).get(LotViewModel::class.java)
    }


    lateinit var lotSelected: LotReservation
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLotDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        lotViewModel.lots.observe(viewLifecycleOwner) { _lot ->
            lot = _lot.find { lotNumber ->
                lotNumber.parkingLot == lotSelected.parkingLot
            }
        }

        // receipt bundle
        arguments?.let {
            lotSelected = it.getSerializable("objectLot") as LotReservation
            initRecyclerWiewReservations(lotSelected.reswervationList)
        }

        binding = FragmentLotDetailsBinding.bind(view)

        //FloatingActionButton
        binding?.floatingActionButton2?.setOnClickListener() {
            findNavController().navigate(R.id.action_lotDetailFragment_to_addReservationFragment)
        }
    }

    //RecyclerView
    private fun initRecyclerWiewReservations(listR: MutableList<Reservation>?) {
        binding?.rvReservations?.apply {
            listR?.let {
                adapter = ReservationAdapter(it) { reservation, pos ->
                    onDeleteReservation(
                        reservation, this, it, pos

                    )
                }
            }

        }
    }


    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    fun onDeleteReservation(
        reservation: Reservation, recyclerView: RecyclerView,
        reservationList: MutableList<Reservation>, pos: Int
    ) {

        val dialog = DeleteDialogFragment()
        dialog.onDeleteClick = { codeText ->
            viewModel.deleteReservation(reservation, codeText)
            viewModel.successfulDelete.observe(viewLifecycleOwner) { deleteSuccessfuly ->
                if (deleteSuccessfuly) {
                    reservationList.removeAt(pos)

                    recyclerView.adapter?.notifyItemRemoved(pos)

                    Toast.makeText(context, "Proccesed correctly", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(context, "Could not be processed", Toast.LENGTH_LONG).show()
                }
            }


        }
        val fm = activity?.supportFragmentManager
        fm?.let {
            dialog.show(it, "Costum Dialog")

        }
    }

    override fun onResume() {
        super.onResume()
        lotViewModel.loadData()
    }

}





