package com.example.parkingapp.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotDetailsBinding
import com.example.domain.model.Lot
import com.example.parkingapp.reservationAdapter.Reservation
import com.example.parkingapp.reservationAdapter.ReservationAdapter
import com.example.parkingapp.viewmodels.ReservationListViewModel


class LotDetailFragment : Fragment(), ItemReservationOnRecyclerViewClicked {

    private var binding: FragmentLotDetailsBinding? = null
    private val viewModel: ReservationListViewModel by viewModels()
    lateinit var lotSelected: com.example.domain.model.Lot
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

        // receipt bundle
        arguments?.let {
            lotSelected = it.getSerializable("objectLot") as Lot

        }

//      binding = FragmentLotDetailsBinding.bind(view)
        Toast.makeText(context, "llego bien", Toast.LENGTH_LONG).show()

        //Back arrow in action bar -> To change button to arrow
        binding?.buttonTest?.setOnClickListener() {
            findNavController().navigate(R.id.action_lotDetailFragment_to_lotsFragment)
        }

        val nav  = Navigation.createNavigateOnClickListener(R.id.action_lotDetailFragment_to_lotsFragment)

        //FloatingActionButton
        binding?.floatingActionButton2?.setOnClickListener() {
            findNavController().navigate(R.id.action_lotDetailFragment_to_addReservationFragment)
        }
    }

    //RecyclerView
    private fun initRecyclerWiewReservations(listR : List<Reservation>) {

        binding?.rvReservations?.apply {

            adapter = ReservationAdapter(listR, this@LotDetailFragment)
        }
    }


    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }


    //Show dialog in cancel button
    override fun onClickReservation(reservation: Reservation) {
        Toast.makeText(activity, "probando:" + reservation.parkingLot, Toast.LENGTH_SHORT).show()
       // binding?.rvReservations?.setOnClickListener {

            var dialog = DeleteDialogFragment()
            val fm = activity?.supportFragmentManager
            fm?.let{
                dialog.show(it, "Costum Dialog")
            }

       // }
    }


}
interface ItemReservationOnRecyclerViewClicked{
    fun onClickReservation(reservation: Reservation)
}



