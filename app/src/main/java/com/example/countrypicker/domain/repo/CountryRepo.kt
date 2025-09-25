package com.example.countrypicker.domain.repo

import com.example.countrypicker.domain.model.Country

interface CountryRepo {
    fun getAllCountries(): List<Country>
}