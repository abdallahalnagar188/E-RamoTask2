package com.example.domain.repo

import com.example.domain.entity.BrokersResponse

interface BrokersRepo {
    suspend fun getBrokersFromRemote():BrokersResponse
}