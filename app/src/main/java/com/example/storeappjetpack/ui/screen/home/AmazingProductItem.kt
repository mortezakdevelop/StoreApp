package com.example.storeappjetpack.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.storeappjetpack.domain.model.HomeAmazingModel
import com.example.storeappjetpack.ui.utils.extensions.Extensions.formatPrice
import com.example.storeappjetpack.ui.utils.extensions.Extensions.formatSellsCount
import java.time.format.TextStyle

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun AmazingProductItem(
    product: HomeAmazingModel,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .width(150.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier.padding(6.dp)
        ) {
            GlideImage(
                model = product.image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(6.dp))
            )

            Spacer(Modifier.height(6.dp))

            Text(
                text = product.name,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                color = Color(0xFF212121), // gray_900
                fontSize = 12.sp,
                lineHeight = 16.sp
            )

            Spacer(Modifier.height(6.dp))

            // درصد + قیمت‌ها
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                DiscountChip(percent = product.offPercent)

                Column(horizontalAlignment = Alignment.End) {
                    Text(
                        text = formatPrice(product.amazingPrice),
                        color = Color(0xFF616161), // gray_700
                        fontSize = 12.sp
                    )
                    Text(
                        text = formatPrice(product.price),
                        color = Color(0xFF9E9E9E), // gray_500
                        fontSize = 11.sp,
                        style = androidx.compose.ui.text.TextStyle(textDecoration = TextDecoration.LineThrough)
                    )
                }
            }

            Spacer(Modifier.height(8.dp))

            val progress = remember(product.sellsCount, product.number) {
                if (product.number <= 0) 0f else (product.sellsCount.toFloat() / product.number.toFloat())
                    .coerceIn(0f, 1f)
            }

            LinearProgressIndicator(
                progress = { progress },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .clip(RoundedCornerShape(50)),
            )

            Spacer(Modifier.height(6.dp))

            // شمارش + تایمر
            val timeText by rememberCountdownText(endTimeMillis = product.amazingTime)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = formatSellsCount(product.sellsCount),
                    fontSize = 11.sp,
                    color = Color(0xFF616161) // gray_700
                )

                Text(
                    text = timeText,
                    fontSize = 11.sp,
                    color = Color(0xFF616161),
                    // چون زمان بهتره LTR باشه:
                    style = LocalTextStyle.current.copy(textDirection = TextDirection.Ltr)
                )
            }
        }
    }
}