package com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dmitriy_liubinskiy.taptapcat.R
import com.dmitriy_liubinskiy.taptapcat.core.Constants.CAT_IMG_STUB
import com.dmitriy_liubinskiy.taptapcat.core.Constants.FEED_CAT
import com.dmitriy_liubinskiy.taptapcat.core.Constants.SATIETY

@Composable
fun Content(
    padding: PaddingValues,
    catSatietyLevel: Int,
    buttonColor: Color,
    rotationAngle: Float,
    increaseCatSatiety: () -> Unit
) {

    Column(
        modifier = Modifier.padding(padding),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 10.dp, 16.dp, 0.dp),
            horizontalArrangement = Arrangement.End,
        ) {
            Text(
                text = "$SATIETY: $catSatietyLevel",
                fontSize = 24.sp,
                fontStyle = Italic
            )
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceAround,

            ) {
            Spacer(modifier = Modifier)
            Image(
                painter = painterResource(id = R.drawable.img_cat),
                contentDescription = CAT_IMG_STUB,
                modifier = Modifier
                    .fillMaxSize(0.4f)
                    .align(Alignment.CenterHorizontally)
                    .graphicsLayer { rotationY = rotationAngle }
            )
            Button(
                onClick = {
                    increaseCatSatiety()
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(0.4f),
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor,
                    contentColor = MaterialTheme.colorScheme.background
                ),
                elevation = ButtonDefaults.buttonElevation(10.dp)
            ) {
                Text(
                    text = FEED_CAT,
                    modifier = Modifier.padding(0.dp, 4.dp),
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
