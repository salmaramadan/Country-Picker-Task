package com.example.countrypicker.data.repoImpl

import com.example.countrypicker.domain.model.Country
import com.example.countrypicker.domain.repo.CountryRepo

class CountryRepoImpl : CountryRepo {
    override fun getAllCountries(): List<Country> {
        return listOf(
            Country("Egypt", "EG", "+20", "https://flagcdn.com/w320/eg.png"),
            Country("Nigeria", "NG", "+234", "https://flagcdn.com/w320/ng.png"),
            Country("South Africa", "ZA", "+27", "https://flagcdn.com/w320/za.png"),
            Country("Kenya", "KE", "+254", "https://flagcdn.com/w320/ke.png"),
            Country("Morocco", "MA", "+212", "https://flagcdn.com/w320/ma.png"),
            Country("Algeria", "DZ", "+213", "https://flagcdn.com/w320/dz.png"),
            Country("Ethiopia", "ET", "+251", "https://flagcdn.com/w320/et.png"),
            Country("Ghana", "GH", "+233", "https://flagcdn.com/w320/gh.png"),
            Country("Uganda", "UG", "+256", "https://flagcdn.com/w320/ug.png"),
            Country("Sudan", "SD", "+249", "https://flagcdn.com/w320/sd.png"),
        )
    }
}
