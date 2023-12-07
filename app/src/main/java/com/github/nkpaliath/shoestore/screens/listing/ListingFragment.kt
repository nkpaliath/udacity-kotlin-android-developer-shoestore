package com.github.nkpaliath.shoestore.screens.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.github.nkpaliath.shoestore.R
import com.github.nkpaliath.shoestore.databinding.FragmentListingBinding
import com.github.nkpaliath.shoestore.databinding.ShoeDetailsBinding
import com.github.nkpaliath.shoestore.models.Shoe
import com.github.nkpaliath.shoestore.models.ShoeStoreViewModel


class ListingFragment : Fragment() {
    private lateinit var binding: FragmentListingBinding
    private val viewModel by activityViewModels<ShoeStoreViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListingBinding.inflate(inflater, container, false)
        val menuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menu.clear()
                menuInflater.inflate(R.menu.logout, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.menuItemLogout -> {
                        findNavController().navigate(ListingFragmentDirections.actionListingFragmentToLoginFragment())
                        true
                    }

                    else -> false
                }
            }

        }, viewLifecycleOwner)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.shoeList.observe(viewLifecycleOwner) {shoes ->
            if (shoes.isEmpty()) {
                binding.textNoShoesInList.visibility = View.VISIBLE
            } else {
                binding.textNoShoesInList.visibility = View.GONE
                for (item in shoes) {
                    binding.listShoes.addView(createShoeItem(item))
                }
            }
        }

        binding.listingScreen = this

    }

    fun onClickAddShoe() {
        findNavController().navigate(ListingFragmentDirections.actionListingFragmentToDetailFragment())
    }

    private fun createShoeItem(newShoe: Shoe): View {
        val shoeBinding = ShoeDetailsBinding.inflate(layoutInflater, null, false)
        shoeBinding.shoeDetails = newShoe
        return shoeBinding.root
    }
}