package com.example.domain.entity

data class BrokersResponse(
    val `data`: Data,
    val message: String,
    val status: Int
)