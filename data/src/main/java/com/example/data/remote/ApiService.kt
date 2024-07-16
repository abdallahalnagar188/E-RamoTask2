package com.example.data.remote

import com.example.domain.entity.BrokersResponse
import retrofit2.http.GET

interface ApiService {

    @GET("mobile/brokers")
    suspend fun getBrokers():BrokersResponse
}