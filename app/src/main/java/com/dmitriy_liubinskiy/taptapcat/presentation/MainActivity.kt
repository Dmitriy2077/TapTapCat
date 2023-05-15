package com.dmitriy_liubinskiy.taptapcat.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.CatSatietyScreen
import com.dmitriy_liubinskiy.taptapcat.presentation.ui.theme.TapTapCatTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           TapTapCatTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CatSatietyScreen()
                }
            }
        }
    }
}
