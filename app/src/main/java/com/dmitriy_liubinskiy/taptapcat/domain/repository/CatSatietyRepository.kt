package com.dmitriy_liubinskiy.taptapcat.domain.repository

import com.dmitriy_liubinskiy.taptapcat.domain.model.CatSatiety
import kotlinx.coroutines.flow.Flow

interface CatSatietyRepository {

    fun getLastSatietyLevel(): Flow<CatSatiety>

    suspend fun addSatietyLevel(catSatiety: CatSatiety)

//    fun getAllSatietyLevels(): Flow<CatSatietyList>
}
