package com.example.countrypicker.presentation.ui.country_picker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun CountryPickerScreen(viewModel: CountryPickerViewModel) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text("One last step", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Please login or signup for a", fontSize = 16.sp)
        Row {
            Text("free", fontSize = 16.sp, fontWeight = FontWeight.Bold)
            Text(" account to continue", fontSize = 16.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .background(Color(0xFFF2F2F2), shape = MaterialTheme.shapes.small)
                .clickable { expanded = true }
                .padding(horizontal = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = viewModel.selectedCountry.flagRes,
                contentDescription = "${viewModel.selectedCountry.name} flag",
                modifier = Modifier.size(32.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))
            Text(text = viewModel.selectedCountry.dialCode, fontSize = 18.sp)
            Spacer(modifier = Modifier.width(12.dp))
            TextField(
                value = viewModel.phoneNumber,
                onValueChange = { viewModel.onPhoneChanged(it) },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("7xxxxxxxxx") },
                singleLine = true
            )
        }

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            viewModel.countries.forEach { country ->
                DropdownMenuItem(
                    text = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            AsyncImage(
                                model = country.flagRes,
                                contentDescription = "${country.name} flag",
                                modifier = Modifier.size(28.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text("${country.name} (${country.dialCode})")
                        }
                    },
                    onClick = {
                        viewModel.onCountrySelected(country)
                        expanded = false
                    }
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))
        Text("We will use this to verify your account", fontSize = 12.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(24.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = viewModel.isChecked,
                onCheckedChange = { viewModel.onCheckedChanged(it) }
            )
            Text(
                buildAnnotatedString {
                    append("I agree and comply to the ")
                    withStyle(style = SpanStyle(color = Color.Blue)) {
                        append("community guidelines")
                    }
                }
            )
        }


        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {},
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF673AB7)),
            shape = CircleShape
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Continue",
                    color = Color.White,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.width(200.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                    contentDescription = "Continue",
                    tint = Color.White
                )
            }
        }
    }
}
