package com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.components

import android.content.Intent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.dmitriy_liubinskiy.taptapcat.R
import com.dmitriy_liubinskiy.taptapcat.presentation.ui.theme.BlueX

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(catSatietyLevel: Int) {
    val shareIntent = Intent.createChooser(createShareIntent(catSatietyLevel), null)
    val context = LocalContext.current

    TopAppBar(title = {
        Text(
            text = stringResource(R.string.app_name),
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )
    },
        actions = {
            IconButton(onClick = { context.startActivity(shareIntent) }) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = null,
                    tint = Color(BlueX.value)
                )
            }
        }
    )
}
