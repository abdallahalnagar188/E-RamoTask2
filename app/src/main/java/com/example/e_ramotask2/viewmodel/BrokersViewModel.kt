package com.example.e_ramotask2.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.BrokersResponse
import com.example.domain.usecase.GetBrokers
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BrokersViewModel @Inject constructor(
    private val getBrokersUseCase: GetBrokers
) : ViewModel() {
    private val _brokers: MutableStateFlow<BrokersResponse?> = MutableStateFlow(null)
    val brokers: StateFlow<BrokersResponse?> get() = _brokers

    fun getBrokers() {
        viewModelScope.launch {
            try {
                _brokers.value = getBrokersUseCase()
                Log.e("success", _brokers.value.toString())

            } catch (e: Exception) {
                Log.e("BrokersViewModel", e.message.toString())
            }
        }
    }
}