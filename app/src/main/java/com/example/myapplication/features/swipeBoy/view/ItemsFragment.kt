package com.example.myapplication.features.swipeBoy.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentItemsBinding
import com.example.myapplication.features.BaseFragment
import com.example.myapplication.features.swipeBoy.viewmodel.Item
import com.example.myapplication.features.swipeBoy.viewmodel.ItemsViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ItemsFragment : BaseFragment() {

    private lateinit var binding: FragmentItemsBinding
    private val viewModel: ItemsViewModel by viewModels { viewModelFactory }
    private lateinit var itemAdapter: ItemAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        itemAdapter = ItemAdapter()
        binding.recyclerView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(requireContext())
            addSwipeEndListener(
                action = Swiper.Action(
                    color = ContextCompat.getColor(requireContext(), android.R.color.holo_red_dark)
                ),
                listener = itemAdapter
            )
            addSwipeStartListener(
                action = Swiper.Action(
                    color = ContextCompat.getColor(requireContext(), android.R.color.holo_blue_dark)
                ),
                listener = itemAdapter
            )

            addSwipeEndListener2(itemAdapter) {

            }
        }

        itemAdapter.onDelete = { item, position ->
            requestConfirmation(item, position)
        }

        viewModel.items.observe(viewLifecycleOwner) {
            itemAdapter.submitList(ArrayList(it))
        }
    }

    private fun requestConfirmation(item: Item, position: Int) =
        MaterialAlertDialogBuilder(requireContext())
            .setTitle("Remove item")
            .setMessage("Do you want to remove this item")
            .setNegativeButton("No") { dialogInterface, _ ->
                itemAdapter.notifyItemChanged(position)
                dialogInterface.dismiss()
            }
            .setPositiveButton("Yes") { _, _ ->
                viewModel.remove(item)
            }
            .show()
}