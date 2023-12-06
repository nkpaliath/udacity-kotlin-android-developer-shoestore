package com.github.nkpaliath.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ShoeStoreViewModel : ViewModel() {
    private val _inventory: MutableList<Shoe> = mutableListOf()

    private val _shoesList = MutableLiveData<List<Shoe>>()
    private var _isUserAuthenticated = MutableLiveData<Boolean>()

    init {
        _shoesList.value = _inventory
        _isUserAuthenticated.value = false
    }

    val shoeList: LiveData<List<Shoe>> get() = _shoesList
    val isUserAuthenticated: LiveData<Boolean> get() = _isUserAuthenticated

    fun addNewShoe(shoeName: String, companyName: String, shoeSize: Int, shoeDescription: String) {
        val newShoe = Shoe(shoeName, companyName, shoeSize, shoeDescription)
        _inventory.add(newShoe)
    }

    fun toggleUserAuthentication() {
        _isUserAuthenticated.value = _isUserAuthenticated.value?.not()
    }
}