package com.example.combolifestyle35.di

import android.app.Application
import androidx.room.Room
import com.example.combolifestyle35.model.ComboRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(
        app: Application
    ) = Room.databaseBuilder(app, ComboRoomDatabase::class.java, "combo_database")
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    fun provideTaskDao(db: ComboRoomDatabase) = db.comboDao()

    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}

@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope