package com.example.countrypicker.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.countrypicker.data.repoImpl.CountryRepoImpl
import com.example.countrypicker.domain.usecase.CountryUseCase
import com.example.countrypicker.presentation.ui.country_picker.CountryPickerScreen
import com.example.countrypicker.presentation.ui.country_picker.CountryPickerViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repo = CountryRepoImpl()
        val useCase = CountryUseCase(repo)
        val viewModel = CountryPickerViewModel(useCase)

        setContent {
            CountryPickerScreen(viewModel)
        }
    }
}
