package com.dmitriy_liubinskiy.taptapcat.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dmitriy_liubinskiy.taptapcat.domain.model.CatSatiety

@Database(
    entities = [CatSatiety::class],
    version = 1,
    exportSchema = false
)
abstract class CatSatietyDatabase : RoomDatabase() {
    abstract fun catSatietyDao(): CatSatietyDao
}
