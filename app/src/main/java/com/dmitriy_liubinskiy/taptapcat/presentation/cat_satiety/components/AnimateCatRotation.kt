package com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable

@Composable
fun animateCatRotation(isAnimating: Boolean): Float = animateFloatAsState(
    targetValue = if (isAnimating) 360F else 0F,
    animationSpec = tween(
        durationMillis = 1500,
        easing = LinearOutSlowInEasing
    )
).value
