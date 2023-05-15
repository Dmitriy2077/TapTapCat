package com.dmitriy_liubinskiy.taptapcat.domain.usecases

import com.dmitriy_liubinskiy.taptapcat.domain.model.CatSatiety
import com.dmitriy_liubinskiy.taptapcat.domain.repository.CatSatietyRepository
import javax.inject.Inject

class AddSatietyLevelUseCase @Inject constructor(
    private val repository: CatSatietyRepository
) {
    suspend operator fun invoke(catSatiety: CatSatiety) = repository.addSatietyLevel(catSatiety)
}
