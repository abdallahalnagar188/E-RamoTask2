package com.example.domain.usecase

import com.example.domain.repo.BrokersRepo

class GetBrokers(private val brokersRepo: BrokersRepo) {
    suspend operator fun invoke() = brokersRepo.getBrokersFromRemote()
}