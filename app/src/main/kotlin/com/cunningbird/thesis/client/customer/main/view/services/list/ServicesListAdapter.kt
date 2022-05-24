package com.cunningbird.thesis.client.customer.main.view.services.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cunningbird.thesis.client.customer.databinding.ItemServiceBinding
import com.cunningbird.thesis.client.customer.main.domain.entities.service.Service

class ServicesListAdapter(private val onClickEvent: (p: Int) -> Unit) :
    RecyclerView.Adapter<ServicesListAdapter.ServiceViewHolder>() {

    var list: List<Service> = arrayListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val binding = ItemServiceBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return ServiceViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        holder.title.text = list[position].title
        holder.amount.text = list[position].price.toString() + "₽"
        holder.image.setOnClickListener {
            onClickEvent(holder.adapterPosition)
        }
    }

    override fun getItemCount() = list.size

    inner class ServiceViewHolder(binding: ItemServiceBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val binding = binding.root
        val image = binding.ivService
        val title = binding.tvServiceName
        val amount = binding.tvServiceAmount
    }
}