package com.example.e_ramotask2.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.DataX
import com.example.e_ramotask2.databinding.BrokerItemBinding

class BrokersAdapter :
    ListAdapter<DataX, BrokersAdapter.BrokerViewHolder>(CategoryDiffCallback()) {

    class BrokerViewHolder(private val binding: BrokerItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @SuppressLint("SetTextI18n")
        fun bind(broker: DataX) {
            binding.nameTv.text = broker.name
            binding.descriptionTv.text = broker.description
            binding.brokerTypeTv.text = " ${broker.property_for_sale} Property for sale "
            binding.propertiesCountTv.text = "${broker.property_for_rent}  Property for rent"
            Glide.with(binding.root.context).load(broker.logo).into(binding.logo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BrokerViewHolder {
        val binding = BrokerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BrokerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BrokerViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    class CategoryDiffCallback : DiffUtil.ItemCallback<DataX>() {
        override fun areItemsTheSame(
            oldItem: DataX,
            newItem: DataX
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: DataX,
            newItem: DataX
        ): Boolean {
            return oldItem == newItem
        }
    }

}