package com.example.parkingapp.fragments
import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.model.Lot
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotDetailsBinding
import com.example.domain.model.Reservation
import com.example.parkingapp.reservationAdapter.ReservationAdapter
import com.example.parkingapp.viewmodels.LotViewModel
import com.example.parkingapp.viewmodels.LotViewModelProvider
import com.example.parkingapp.viewmodels.ReservationViewModel


class LotDetailFragment : Fragment(), ItemReservationOnRecyclerViewClicked {

    private var binding: FragmentLotDetailsBinding? = null

    private val viewModel: ReservationViewModel by lazy {
        LotViewModelProvider(requireActivity()).get(ReservationViewModel::class.java)
    }


    lateinit var lotSelected: Lot
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.reservations.observe(viewLifecycleOwner) { reservationList ->
            initRecyclerWiewReservations(reservationList)
        }

        binding = FragmentLotDetailsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // receipt bundle
        arguments?.let {
            lotSelected = it.getSerializable("objectLot") as Lot
            viewModel.loadReservations()
            val mensaje = viewModel.loadReservations().toString()
            Log.d(TAG,mensaje)
        }

        binding = FragmentLotDetailsBinding.bind(view)

        //FloatingActionButton
        binding?.floatingActionButton2?.setOnClickListener() {
            findNavController().navigate(R.id.action_lotDetailFragment_to_addReservationFragment)
        }
    }

    //RecyclerView
    private fun initRecyclerWiewReservations(listR: List<Reservation>) {
        binding?.rvReservations?.apply {
            adapter = ReservationAdapter(listR, this@LotDetailFragment)
        }
    }

    //Show dialog in cancel button
    override fun onDeleteReservation(reservation: Reservation) {
        Toast.makeText(activity, "delete Reservation" + reservation.parkingLot, Toast.LENGTH_SHORT)
            .show()

        var dialog = DeleteDialogFragment()
        dialog.onDeleteClick = { codeText ->
         viewModel.deleteReservation(reservation, codeText)

            }
        val fm = activity?.supportFragmentManager
        fm?.let {
            dialog.show(it, "Costum Dialog")

        }
    }
        override fun onDestroyView() {
            binding = null
            super.onDestroyView()
        }

    }

    interface ItemReservationOnRecyclerViewClicked {
        fun onDeleteReservation(reservation: Reservation)
    }



