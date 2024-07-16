package com.example.e_ramotask2

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.e_ramotask2.adapters.BrokersAdapter
import com.example.e_ramotask2.databinding.ActivityMainBinding
import com.example.e_ramotask2.viewmodel.BrokersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:BrokersViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel.getBrokers()
        val brokersAdapter = BrokersAdapter()
        lifecycleScope.launch {
            viewModel.brokers.collect {
                Log.e("elnagar", it?.data?.original?.data.toString(), )
                brokersAdapter.submitList(it?.data?.original?.data)
                binding.brokerRv.adapter = brokersAdapter

            }
        }
    }
}