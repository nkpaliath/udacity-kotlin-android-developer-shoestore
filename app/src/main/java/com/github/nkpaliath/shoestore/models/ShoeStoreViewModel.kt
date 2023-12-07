package com.github.nkpaliath.shoestore.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ShoeStoreViewModel : ViewModel() {
    private val _inventory: MutableList<Shoe> = mutableListOf()

    private val _shoesList = MutableLiveData<List<Shoe>>()
    private var _isUserAuthenticated = MutableLiveData<Boolean>()

    var shoeName = MutableLiveData<String>()
    var companyName = MutableLiveData<String>()
    var shoeSize = MutableLiveData<String>()
    var shoeDescription = MutableLiveData<String>()

    init {
        _shoesList.value = _inventory
        _isUserAuthenticated.value = false
        resetShoeDetails()
    }

    val shoeList: LiveData<List<Shoe>> get() = _shoesList
    val isUserAuthenticated: LiveData<Boolean> get() = _isUserAuthenticated

    fun addNewShoe() {
        val newShoe = Shoe(
            shoeName.value!!,
            companyName.value!!,
            (shoeSize.value?.toInt() ?: 0),
            shoeDescription.value!!
        )
        _inventory.add(newShoe)
    }

    fun toggleUserAuthentication() {
        _isUserAuthenticated.value = _isUserAuthenticated.value?.not()
    }

    fun resetShoeDetails() {
        shoeSize.value = ""
        shoeName.value = ""
        companyName.value = ""
        shoeDescription.value = ""
    }
}