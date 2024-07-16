package com.example.data.repo

import com.example.data.remote.ApiService
import com.example.domain.entity.BrokersResponse
import com.example.domain.repo.BrokersRepo

class BrokersRepoImpl(private val apiService: ApiService) : BrokersRepo {
    override suspend fun getBrokersFromRemote(): BrokersResponse = apiService.getBrokers()
}