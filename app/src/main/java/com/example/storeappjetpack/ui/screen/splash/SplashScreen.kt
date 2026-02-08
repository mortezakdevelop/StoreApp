package com.example.storeappjetpack.ui.screen.splash

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast
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
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.storeappjetpack.R
import com.example.storeappjetpack.ui.component.Loading3Dots
import com.example.storeappjetpack.ui.theme.body2
import com.example.storeappjetpack.ui.theme.splashBg
import com.example.storeappjetpack.ui.utils.Constants
import kotlinx.coroutines.delay
import java.nio.file.WatchEvent

@Composable
fun SplashScreen(/*navHostController: NavHostController*/) {
    val context = LocalContext.current

    Splash(
        isNetworkAvailable = isNetworkAvailable(context),
        onRetryClick = {
            if (isNetworkAvailable(context)) {
                if (Constants.isFromPurchase) {
                    /*     navHostController.navigate(
                             Screen.ConfirmPurchase.route+"?orderId=$purchaseOrderId?orderPrice=$purchasePrice"
                         ) {
                             popUpTo(Screen.Splash.route) {
                                 inclusive = true
                             }
                         }*/
                } else {
                    /* navHostController.navigate(Screen.Home.route) {
                         popUpTo(Screen.Splash.route) {
                             inclusive = true
                         }
                     }*/
                }

            } else {
                Toast.makeText(
                    context, context.getString(R.string.check_net),
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    LaunchedEffect(true) {
        delay(1000)

        if (Constants.isFromPurchase) {
            /*    navHostController.navigate(
                    Screen.ConfirmPurchase.route+"?orderId=$purchaseOrderId?orderPrice=$purchasePrice"
                ) {
                    popUpTo(Screen.Splash.route) {
                        inclusive = true
                    }
                }*/
        } else {
            /*      navHostController.navigate(Screen.Home.route) {
                      popUpTo(Screen.Splash.route) {
                          inclusive = true
                      }
                  }*/
        }


    }
}

//.background(MaterialTheme.colorScheme.splashBg)

@Composable
fun Splash(isNetworkAvailable: Boolean, onRetryClick: () -> Unit) {

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
                Retry(onRetryClick = onRetryClick)
            }
        }
    }
}

@Composable
private fun Retry(onRetryClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.check_net),
            style = MaterialTheme.typography.body2,
            color = Color.White
        )
        IconButton(
            modifier = Modifier.padding(top = 4.dp),
            onClick = { onRetryClick() }) {
            Icon(
                imageVector = Icons.Filled.Refresh,
                contentDescription = "",
                tint = Color.White,
                modifier = Modifier.size(27.dp)
            )
        }
    }

}

fun isNetworkAvailable(context: Context): Boolean {
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val network = connectivityManager.activeNetwork ?: return false
    val activeNetwork = connectivityManager.getNetworkCapabilities(network) ?: return false
    return when {
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
        activeNetwork.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> true
        else -> false
    }
}

@Preview(showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen()
}