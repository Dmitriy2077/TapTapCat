package com.dmitriy_liubinskiy.taptapcat.data.repository

import com.dmitriy_liubinskiy.taptapcat.data.sources.local.CatSatietyDao
import com.dmitriy_liubinskiy.taptapcat.domain.model.CatSatiety
import com.dmitriy_liubinskiy.taptapcat.domain.repository.CatSatietyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CatSatietyRepositoryImpl @Inject constructor(
    private val catSatietyDao: CatSatietyDao
) : CatSatietyRepository {

    override fun getLastSatietyLevel(): Flow<CatSatiety> {
        return catSatietyDao.getLastSatietyLevel()
    }

    override suspend fun addSatietyLevel(catSatiety: CatSatiety) {
        return catSatietyDao.addSatietyLevel(catSatiety)
    }

//    override fun getAllSatietyLevels() = catSatietyDao.getAllSatietyLevels()
}
