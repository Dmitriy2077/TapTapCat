package com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.components.Content
import com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.components.TopBar
import com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.components.animateCatRotation

@Composable
fun CatSatietyScreen(viewModel: CatSatietyViewModel = hiltViewModel()) {
    val catSatietyLevel: Int = viewModel.catSatiety.value.satiety

    Scaffold(
        topBar = {
            TopBar(catSatietyLevel)
        },
        content = { padding ->
            Content(
                padding,
                catSatietyLevel,
                viewModel.buttonColor.value,
                animateCatRotation(viewModel.isAnimating.value),
                viewModel::increaseCatSatiety
            )
        }
    )
}
