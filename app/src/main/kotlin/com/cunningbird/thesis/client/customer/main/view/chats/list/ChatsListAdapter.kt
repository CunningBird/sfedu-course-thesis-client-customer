package com.cunningbird.thesis.client.customer.main.view.chats.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.cunningbird.thesis.client.customer.databinding.ItemMessageBinding

class ChatsListAdapter(private val onClickEvent: (p:Int) -> Unit) : RecyclerView.Adapter<ChatsListAdapter.MessagesViewHolder>() {
    // todo изменить на список объектов и оттуда получать данные
    var list: List<String> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessagesViewHolder {
        val binding = ItemMessageBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return MessagesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MessagesViewHolder, position: Int) {
        holder.image.load("https://sun9-40.userapi.com/impg/okrr7lk-uTHQ6Hd7oxroSGAizxD7_vdMvUqIxg/vJnAl-FEDG0.jpg?size=1620x2160&quality=95&sign=f99f69daaee0315ace8912dd5377990a&type=album") {
            ////   todo сделать заглушку
            ////            crossfade(true)
////            placeholder(R.drawable.заглушка)
            transformations(CircleCropTransformation())
//        }
        }
        holder.name.text = list[position]
        holder.description.text = list[position]

        holder.apply {
            val onClickEvent = View.OnClickListener { onClickEvent(adapterPosition) }
            image.setOnClickListener(onClickEvent)
            name.setOnClickListener(onClickEvent)
            description.setOnClickListener(onClickEvent)
        }
    }

    override fun getItemCount() = list.size

    inner class MessagesViewHolder(binding: ItemMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val image = binding.cvUserImg
        val name = binding.tvUserName
        val description = binding.tvUserDescription
    }
}