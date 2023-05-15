package com.dmitriy_liubinskiy.taptapcat.domain.usecases

import com.dmitriy_liubinskiy.taptapcat.domain.repository.CatSatietyRepository
import javax.inject.Inject

class GetLastSatietyLevelUseCase @Inject constructor(
    private val repository: CatSatietyRepository
) {
    operator fun invoke() = repository.getLastSatietyLevel()
}
