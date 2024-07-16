package com.example.e_ramotask2.di

import com.example.domain.repo.BrokersRepo
import com.example.domain.usecase.GetBrokers
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideUseCase(brokersRepo: BrokersRepo): GetBrokers {
        return GetBrokers(brokersRepo)
    }
}