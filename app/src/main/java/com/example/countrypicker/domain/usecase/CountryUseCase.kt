package com.example.countrypicker.domain.usecase

import com.example.countrypicker.domain.model.Country
import com.example.countrypicker.domain.repo.CountryRepo

class CountryUseCase (
    private val repository: CountryRepo
) {
    operator fun invoke(): List<Country> = repository.getAllCountries()
}