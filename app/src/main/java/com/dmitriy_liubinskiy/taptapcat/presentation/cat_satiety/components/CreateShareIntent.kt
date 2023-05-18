package com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety.components

import android.content.Intent
import com.dmitriy_liubinskiy.taptapcat.core.Constants.SHARE_SATIETY_SCORE

fun createShareIntent(catSatietyLevel: Int) = run {
    Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(
            Intent.EXTRA_TEXT,
            "$SHARE_SATIETY_SCORE $catSatietyLevel !"
        )
        type = "text/plain"
    }
}
