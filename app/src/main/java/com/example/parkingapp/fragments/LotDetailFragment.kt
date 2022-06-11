

package com.example.parkingapp.fragments

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.domain.model.LotReservation
import com.example.domain.model.Reservation
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotDetailsBinding
import com.example.parkingapp.reservationAdapter.ReservationAdapter
import com.example.parkingapp.viewmodels.LotViewModelProvider
import com.example.parkingapp.viewmodels.ReservationViewModel


class LotDetailFragment : Fragment(), ItemReservationOnRecyclerViewClicked {

    private var binding: FragmentLotDetailsBinding? = null

    private val viewModel: ReservationViewModel by lazy {
        LotViewModelProvider(requireActivity()).get(ReservationViewModel::class.java)
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




        // receipt bundle
        arguments?.let {
            lotSelected = it.getSerializable("objectLot") as LotReservation
            //      viewModel.loadReservations()
            val mensaje = "hola"//viewModel.loadReservations().toString()
            Log.d(TAG,mensaje)

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
                adapter = ReservationAdapter(it, this@LotDetailFragment)
            }

        }
    }


    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }

    override fun onDeleteReservation(reservation: Reservation) {
        var dialog = DeleteDialogFragment()
        dialog.onDeleteClick = { codeText ->
                viewModel.deleteReservation(reservation, codeText)
            viewModel.successfulDelete.observe(viewLifecycleOwner){ deleteSuccessfuly ->
                if(deleteSuccessfuly){
                    Toast.makeText(context, "Proccesed correctly", Toast.LENGTH_LONG).show()
                }else{
                    Toast.makeText(context, "Could not be processed", Toast.LENGTH_LONG).show()
                }
            }


            }
        val fm = activity?.supportFragmentManager
        fm?.let {
            dialog.show(it, "Costum Dialog")

        }
    }

}

interface ItemReservationOnRecyclerViewClicked {
    fun onDeleteReservation(reservation: Reservation)
}



