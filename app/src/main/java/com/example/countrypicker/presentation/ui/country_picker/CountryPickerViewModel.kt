package com.example.countrypicker.presentation.ui.country_picker

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.countrypicker.domain.model.Country
import com.example.countrypicker.domain.usecase.CountryUseCase

class CountryPickerViewModel(
    private val countryUseCase: CountryUseCase
) : ViewModel() {

    var selectedCountry by mutableStateOf(countryUseCase().first())
        private set

    var phoneNumber by mutableStateOf("")
        private set

    var isChecked by mutableStateOf(false)
        private set

    val countries: List<Country> = countryUseCase()

    fun onCountrySelected(country: Country) {
        selectedCountry = country
    }

    fun onPhoneChanged(value: String) {
        phoneNumber = value
    }

    fun onCheckedChanged(value: Boolean) {
        isChecked = value
    }
}
