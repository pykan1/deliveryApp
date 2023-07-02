package com.example.deliveryapp.di

import android.content.Context
import androidx.room.Room
import com.example.deliveryapp.data.api.apiService.AuthService
import com.example.deliveryapp.data.api.apiService.BuyerService
import com.example.deliveryapp.data.local.AppDatabase
import com.example.deliveryapp.data.local.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    fun provideUserDatabase(@ApplicationContext appContext: Context): AppDatabase {
        return Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            "user"
        ).build()
    }

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserRepository {
        return appDatabase.userDao()
    }

    @Provides
    fun provideAuthService(): AuthService {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.108:8001")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AuthService::class.java)
    }

    @Provides
    fun provideBuyerService(): BuyerService {
        return Retrofit.Builder()
            .baseUrl("http://192.168.0.108:8002")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(BuyerService::class.java)
    }

}