package com.dmitriy_liubinskiy.taptapcat.presentation.cat_satiety

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dmitriy_liubinskiy.taptapcat.domain.model.CatSatiety
import com.dmitriy_liubinskiy.taptapcat.domain.usecases.UseCases
import com.dmitriy_liubinskiy.taptapcat.presentation.ui.theme.Amber900
import com.dmitriy_liubinskiy.taptapcat.presentation.ui.theme.BlueX
import com.dmitriy_liubinskiy.taptapcat.presentation.ui.theme.Yellow900
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatSatietyViewModel @Inject constructor(
    private val satietyUseCases: UseCases
) : ViewModel() {

    var catSatiety = mutableStateOf(CatSatiety())
        private set

    var buttonColor = mutableStateOf(Color(BlueX.value))
        private set

    var isAnimating = mutableStateOf(false)
        private set

    init {
        getCatSatietyLevel()
    }

    private fun getCatSatietyLevel() {
        catSatiety.value
        viewModelScope.launch {
            satietyUseCases.getLastSatietyLevel().filterNotNull().collectLatest { satietyLevel ->
                catSatiety.value = satietyLevel
            }
        }
    }

    fun increaseCatSatiety() {
        viewModelScope.launch {
            val currentSatiety = catSatiety.value.satiety
            val newSatiety = CatSatiety(
                satiety = currentSatiety.inc(),
                datetime = System.currentTimeMillis()
            )
            satietyUseCases.addSatietyLevel(newSatiety)
            updateAnimationState(newSatiety.satiety)
        }
    }

    private fun updateAnimationState(counterValue: Int) {
        if (counterValue % 5 == 0) {
            buttonColor.value = Color(Yellow900.value)
            isAnimating.value = !isAnimating.value
        } else {
            buttonColor.value = Color(Amber900.value)
        }
    }
}
