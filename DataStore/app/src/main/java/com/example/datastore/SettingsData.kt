package com.example.datastore

import androidx.compose.ui.graphics.Color
import com.example.datastore.ui.theme.Red
import kotlinx.serialization.Serializable

@Serializable
data class SettingsData(
    val textSize: Int = 10,
    val backgroundColor: ULong = Red.value
)
