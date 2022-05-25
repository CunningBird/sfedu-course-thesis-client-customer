package com.cunningbird.thesis.client.customer.main.view.appointments.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.cunningbird.thesis.client.customer.databinding.ItemAppointmentBinding
import com.cunningbird.thesis.client.customer.main.domain.entities.appointment.Appointment
import java.text.SimpleDateFormat

class AppointmentsListAdapter(private val onClickEvent: (p: Int) -> Unit) :
    RecyclerView.Adapter<AppointmentsListAdapter.AppointmentViewHolder>() {

    @SuppressLint("SimpleDateFormat")
    private val formatter = SimpleDateFormat("dd.mm.yyyy hh:mm")

    var list: List<Appointment> = arrayListOf()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppointmentViewHolder {
        val binding = ItemAppointmentBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AppointmentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AppointmentViewHolder, position: Int) {
        // TODO get advert image
        holder.image.load("https://sun9-40.userapi.com/impg/okrr7lk-uTHQ6Hd7oxroSGAizxD7_vdMvUqIxg/vJnAl-FEDG0.jpg?size=1620x2160&quality=95&sign=f99f69daaee0315ace8912dd5377990a&type=album")
        holder.title.text = list[position].advertName
        holder.time.text = list[position].date?.let { formatter.format(it) } // TODO format this
        holder.binding.setOnClickListener {
            onClickEvent(holder.adapterPosition)
        }
    }

    override fun getItemCount() = list.size

    inner class AppointmentViewHolder(binding: ItemAppointmentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val binding = binding.root
        val image = binding.cvUserImg
        val title = binding.tvAppointmentName
        val time = binding.tvAppointmentTime
    }
}