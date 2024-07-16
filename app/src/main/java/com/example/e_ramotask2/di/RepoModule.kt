package com.example.e_ramotask2.di

import com.example.data.remote.ApiService
import com.example.data.repo.BrokersRepoImpl
import com.example.domain.repo.BrokersRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideRepository(apiService: ApiService): BrokersRepo {
        return BrokersRepoImpl(apiService)
    }

}