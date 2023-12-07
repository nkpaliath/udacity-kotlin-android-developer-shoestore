package com.github.nkpaliath.shoestore.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.nkpaliath.shoestore.databinding.FragmentDetailBinding
import com.github.nkpaliath.shoestore.models.ShoeStoreViewModel

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private val viewModel by activityViewModels<ShoeStoreViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.resetShoeDetails()
        binding.detailScreen = this
        binding.detailViewModel = viewModel
    }

    fun onSave() {
        viewModel.addNewShoe()

        findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListingFragment())
    }

    fun onCancel() {
        findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListingFragment())
    }
}