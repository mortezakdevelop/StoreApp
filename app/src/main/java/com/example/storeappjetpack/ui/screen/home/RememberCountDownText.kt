package com.example.storeappjetpack.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay

@Composable
fun rememberCountdownText(endTimeMillis: Long): State<String> {
    val state = remember { mutableStateOf("") }

    LaunchedEffect(endTimeMillis) {
        while (true) {
            val remaining = endTimeMillis - System.currentTimeMillis()
            if (remaining <= 0L) {
                state.value = "تخفیف تمام شد"
                break
            }

            val hour = (remaining / 3600000) % 24
            val min = (remaining / 60000) % 60
            val sec = (remaining / 1000) % 60

            state.value = String.format("%02d:%02d:%02d", hour, min, sec)
            delay(1000)
        }
    }

    return state
}