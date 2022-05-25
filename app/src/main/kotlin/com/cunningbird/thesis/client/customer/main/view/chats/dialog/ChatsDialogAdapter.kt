package com.cunningbird.thesis.client.customer.main.view.chats.dialog

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cunningbird.thesis.client.customer.databinding.ItemFromMessageBinding
import com.cunningbird.thesis.client.customer.databinding.ItemMessageDateHeaderBinding
import com.cunningbird.thesis.client.customer.databinding.ItemToMessageBinding
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.Message

class ChatsDialogAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: List<Message> = arrayListOf()
        set(value) {
            field = value
        }

    companion object {
        const val DATE = 0
        const val FROM = 1
        const val TO = 2
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            FROM -> {
                val binding = ItemFromMessageBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                MessageFromViewHolder(binding)
            }

            TO -> {
                val binding = ItemToMessageBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                MessageToViewHolder(binding)
            }

            else -> {
                val binding = ItemMessageDateHeaderBinding
                    .inflate(LayoutInflater.from(parent.context), parent, false)
                MessageDateViewHolder(binding)
            }
        }
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            //todo нужно преобразовывать строку в дату и время
            is MessageFromViewHolder -> holder.bind(list[position])
            is MessageToViewHolder -> holder.bind(list[position])
            is MessageDateViewHolder -> holder.bind(list[position])
        }
    }

    override fun getItemCount() = list.size

    override fun getItemViewType(position: Int): Int = 1
    // В приложении для клиентов обратная логика
//        when (list[position]) {
//            MessageAuthor.EXECUTOR -> TO
//            MessageAuthor.CUSTOMER -> FROM
//            else -> DATE
//        }


    inner class MessageFromViewHolder(val binding: ItemFromMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.tvText.text = message.text
            binding.tvTime.text = message.date.toString()
        }
    }

    inner class MessageToViewHolder(val binding: ItemToMessageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.tvText.text = message.text
            binding.tvTime.text = message.date.toString()
        }
    }

    inner class MessageDateViewHolder(val binding: ItemMessageDateHeaderBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(message: Message) {
            binding.tvDate.text = message.date.toString()
        }
    }
}