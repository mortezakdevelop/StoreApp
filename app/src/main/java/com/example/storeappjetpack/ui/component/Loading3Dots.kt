package com.example.storeappjetpack.ui.component

import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.storeappjetpack.R

@Composable
fun Loading3Dots(
    isDark: Boolean,
    modifier: Modifier = Modifier,
    size: Dp = 32.dp
) {
    val rawRes = if (isDark) {
        R.raw.loading3dotsdark
    } else {
        R.raw.loading3dots
    }

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(rawRes)
    )

    // اگر فایل خراب/غلط باشد، اینجا composition ممکن است null بماند
    if (composition == null) {
        // فالبک ساده که حداقل چیزی ببینی
        CircularProgressIndicator(modifier = modifier.size(size))
        return
    }

    LottieAnimation(
        composition = composition,
        iterations = LottieConstants.IterateForever,
        modifier = modifier.size(size)
    )
}