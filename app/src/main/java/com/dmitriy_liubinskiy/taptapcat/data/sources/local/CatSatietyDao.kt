package com.dmitriy_liubinskiy.taptapcat.data.sources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.dmitriy_liubinskiy.taptapcat.domain.model.CatSatiety
import kotlinx.coroutines.flow.Flow

@Dao
interface CatSatietyDao {

    @Query("SELECT * FROM satiety_table ORDER BY datetime DESC LIMIT 1")
    fun getLastSatietyLevel(): Flow<CatSatiety>

    @Insert//(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addSatietyLevel(catSatiety: CatSatiety)

//    @Query("SELECT * FROM satiety_table")
//    fun getAllSatietyLevels(): Flow<List<CatSatiety>>
}
