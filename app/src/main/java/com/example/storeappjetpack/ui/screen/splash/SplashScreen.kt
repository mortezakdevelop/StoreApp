package com.example.storeappjetpack.ui.screen.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.storeappjetpack.R
import com.example.storeappjetpack.ui.component.Loading3Dots
import com.example.storeappjetpack.ui.theme.splashBg

@Composable
fun SplashScreen(isNetworkAvailable: Boolean, onRetryClick : () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.splashBg)
            .systemBarsPadding(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Image(
                modifier = Modifier.size(250.dp),
                painter = painterResource(R.drawable.digi_logo),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "در حال آماده سازی اپلیکیشن تستی...",
                color = MaterialTheme.colorScheme.onBackground,
                softWrap = false,
                textAlign = TextAlign.Center    ,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth(0.8f)
            )
        }

        Image(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 100.dp)
                .size(130.dp),
            painter = painterResource(id = R.drawable.digi_txt_white),
            contentDescription = null
        )

        // 🔹 لودینگ / Retry پایین‌تر
        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
        ) {
            if (isNetworkAvailable) {
                Loading3Dots(isDark = false)
            } else {
                onRetryClick()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    //SplashScreen()
}