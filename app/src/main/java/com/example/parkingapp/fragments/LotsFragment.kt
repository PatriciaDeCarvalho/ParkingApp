package com.example.parkingapp.fragments



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.model.Lot
import com.example.parkingapp.R
import com.example.parkingapp.databinding.FragmentLotsBinding
import com.example.parkingapp.lotAdapter.LotAdapter
import com.example.parkingapp.viewmodels.LotListViewModel


class LotsFragment : Fragment(), ItemOnRecyclerViewClicked {

    private var binding: FragmentLotsBinding? = null
    private val viewModel: LotListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentLotsBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //FloatingActionButton
        binding?.floatingActionButton1?.setOnClickListener() {
            findNavController().navigate(R.id.action_lotsFragment_to_addReservationFragment)
        }
        viewModel.lotList.observe(viewLifecycleOwner) { lotList ->
            initRecyclerViewLots(lotList)
        }


    }

    //Recycler View
    private fun initRecyclerViewLots(lotList: List<com.example.domain.model.Lot>) {
        //  val decoration = DividerItemDecoration(this, ConstraintLayoutManager.orientation)

        binding?.rvLots?.apply {

            adapter = LotAdapter(lotList, this@LotsFragment)
        }

    }

    override fun onClick(lot: Lot) {
        Toast.makeText(context, lot.dateOfStart, Toast.LENGTH_LONG).show()

        val bundle = Bundle()
        bundle.putSerializable("objectLot", lot)
        //enviar al fragment siguiente
        findNavController().navigate(
            R.id.action_lotsFragment_to_lotDetailFragment,
            bundle
        )

    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field, if not needed.
        binding = null
        super.onDestroyView()
    }

}

interface ItemOnRecyclerViewClicked {
    fun onClick(lot: com.example.domain.model.Lot)


}

