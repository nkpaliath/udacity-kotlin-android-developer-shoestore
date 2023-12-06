package com.github.nkpaliath.shoestore.screens.instruction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.nkpaliath.shoestore.R
import com.github.nkpaliath.shoestore.databinding.FragmentInstructionBinding
import com.github.nkpaliath.shoestore.models.ShoeStoreViewModel

class InstructionFragment : Fragment() {
    private lateinit var binding: FragmentInstructionBinding
    private val viewModel by activityViewModels<ShoeStoreViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_instruction, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.instructionScreen = this

    }

    fun onClickInventory() {
        viewModel.toggleUserAuthentication()
        findNavController().navigate(InstructionFragmentDirections.actionInstructionFragmentToListingFragment())
    }
}