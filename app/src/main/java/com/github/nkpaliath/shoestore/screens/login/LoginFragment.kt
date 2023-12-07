package com.github.nkpaliath.shoestore.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.nkpaliath.shoestore.databinding.FragmentLoginBinding
import com.github.nkpaliath.shoestore.models.ShoeStoreViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private val viewModel by activityViewModels<ShoeStoreViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginScreen = this
    }

    fun toWelcomeScreen(isNewUser: Boolean) {
        if (viewModel.isUserAuthenticated.value == false) {
            findNavController().navigate(
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(
                    isNewUser
                )
            )
        } else {
            findNavController().navigate(LoginFragmentDirections.actionLoginFragmentToListingFragment())
        }
    }
}