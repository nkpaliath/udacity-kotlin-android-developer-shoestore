package com.github.nkpaliath.shoestore.screens.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.nkpaliath.shoestore.R
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.detailScreen = this
    }

    fun onSave() {
        val shoeName: String = binding.editShoeName.text.toString()
        val companyName: String = binding.editCompanyName.text.toString()
        val shoeSize: Int = if (binding.editShoeSize.text.toString() == "") {
            0
        } else {
            binding.editShoeSize.text.toString().toInt()
        }
        val shoeDescription: String = binding.editShoeDescription.text.toString()

        viewModel.addNewShoe(shoeName, companyName, shoeSize, shoeDescription)

        findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListingFragment())
    }

    fun onCancel() {
        findNavController().navigate(DetailFragmentDirections.actionDetailFragmentToListingFragment())
    }
}