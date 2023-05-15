package com.dmitriy_liubinskiy.taptapcat.di

import android.app.Application
import androidx.room.Room
import com.dmitriy_liubinskiy.taptapcat.core.Constants.DATABASE_NAME
import com.dmitriy_liubinskiy.taptapcat.data.repository.CatSatietyRepositoryImpl
import com.dmitriy_liubinskiy.taptapcat.data.sources.local.CatSatietyDatabase
import com.dmitriy_liubinskiy.taptapcat.domain.repository.CatSatietyRepository
import com.dmitriy_liubinskiy.taptapcat.domain.usecases.AddSatietyLevelUseCase
import com.dmitriy_liubinskiy.taptapcat.domain.usecases.GetLastSatietyLevelUseCase
import com.dmitriy_liubinskiy.taptapcat.domain.usecases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object AppModule {
    @Provides
    @Singleton
    fun provideCatSatietyDatabase(app: Application): CatSatietyDatabase {
        return Room.databaseBuilder(
            app,
            CatSatietyDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideCatSatietyRepository(db: CatSatietyDatabase): CatSatietyRepository {
        return CatSatietyRepositoryImpl(db.catSatietyDao())
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: CatSatietyRepository): UseCases {
        return UseCases(
            getLastSatietyLevel = GetLastSatietyLevelUseCase(repository),
            addSatietyLevel = AddSatietyLevelUseCase(repository)
        )
    }
}
