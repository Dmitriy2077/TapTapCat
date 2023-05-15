package com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.components.animateCatRotation
import com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.components.Content
import com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.components.TopBar

@Composable
fun CatSatietyScreen(viewModel: CatSatietyViewModel = hiltViewModel()) {
    Scaffold(
        topBar = {
            TopBar()
        },
        content = { padding ->
            Content(
                padding,
                viewModel.catSatiety.value.satiety,
                viewModel.buttonColor.value,
                animateCatRotation(viewModel.isAnimating.value),
                viewModel::increaseCatSatiety
            )
        }
    )
}
