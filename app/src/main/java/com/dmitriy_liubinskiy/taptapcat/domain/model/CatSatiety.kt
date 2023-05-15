package com.dmitriy_liubinskiy.taptapcat.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.dmitriy_liubinskiy.taptapcat.core.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CatSatiety(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
//    @ColumnInfo(name = "satiety_level")
    val satiety: Int = 0,
//    @ColumnInfo(name = "datetime")
    val datetime: Long = 0L
)
