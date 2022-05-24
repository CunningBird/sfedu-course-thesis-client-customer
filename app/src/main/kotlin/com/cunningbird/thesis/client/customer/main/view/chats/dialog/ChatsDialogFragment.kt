package com.cunningbird.thesis.client.customer.main.view.chats.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.cunningbird.thesis.client.customer.databinding.FragmentChatsDialogBinding
import com.cunningbird.thesis.client.customer.main.domain.entities.chat.Message
import com.cunningbird.thesis.client.customer.main.view.MainActivity
import com.cunningbird.thesis.client.customer.main.view.chats.list.ChatsListViewModel
import java.util.*

class ChatsDialogFragment : Fragment() {

    private lateinit var binding: FragmentChatsDialogBinding

    val viewModel: ChatsListViewModel by viewModels()

    private lateinit var adapter: ChatsDialogAdapter

    private var messages: MutableList<Message> = arrayListOf()

    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity = (activity as MainActivity)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentChatsDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setViews()
    }

    private fun setViews() {
        mainActivity.changeToolbar("Имя пользователя", true)
        setAdapter()
    }

    private fun setAdapter() {
//        adapter = ChatsDialogAdapter()
//        binding.rvMessages.layoutManager =
//            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
//        binding.rvMessages.adapter = adapter
//        messages = arrayListOf<Message>(
//            Message("sa", "adsaddsszxczx", "YESTERDAY", MessageAuthor.Date),
//            Message("sa", "adzxczx", "12:29", MessageAuthor.CUSTOMER),
//            Message("sa", "adsaddsszxczx", "12:31", MessageAuthor.CUSTOMER),
//            Message("sa", "adzxczx", "12:29", MessageAuthor.EXECUTOR),
//            Message("sa", "ax", "12:39", MessageAuthor.EXECUTOR),
//            Message(
//                "sa",
//                "qqqqdssxcxcxcxcxcxcxcxcxcxcxcxcxcxcxcxcxcxcxcxadsaddsszxczx",
//                "12:59",
//                MessageAuthor.CUSTOMER
//            ),
//            Message("sa", "adzxbvczx", "13:29", MessageAuthor.EXECUTOR),
//            Message("sa", "axlih123321", "14:39", MessageAuthor.EXECUTOR),
//            Message("sa", "adzx22222222222222222222222244444333331czx", "15:50", MessageAuthor.CUSTOMER),
//            Message("sa", "axlih123321", "TODAY", MessageAuthor.Date),
//            Message("sa", "azx6587czx", "19:50", MessageAuthor.CUSTOMER),
//            Message("sa", "ffadzx2224333331czx", "20:05", MessageAuthor.CUSTOMER)
//        )
//        adapter.list = messages
//        adapter.notifyDataSetChanged()
    }

    private fun setListeners() {
        binding.buttonSendMessage.setOnClickListener {
            //todo сделать с сервером
            val text = binding.etChat.text.toString()
            if (text.isNotEmpty()) {
                //todo важно, время зависит от языка пользователя
                val calendar = Calendar.getInstance()
                val hour24hrs = calendar[Calendar.HOUR_OF_DAY]
                val hour12hrs = calendar[Calendar.HOUR]
                val minutes = calendar[Calendar.MINUTE]

                onMessageComing(
                    Message(
                        "sa",
                        text,
                        "$minutes:$hour24hrs",
                        //MessageAuthor.EXECUTOR
                    )
                )
            }
            binding.etChat.text?.clear()
        }
    }

    private fun onMessageComing(message: Message) {
        //todo сделать проверку на дату и если нужно добавить элемент даты
        messages.add(message)
        adapter.notifyItemInserted(messages.lastIndex)
        binding.rvMessages.scrollToPosition(messages.lastIndex);

    }

    fun onMessageUpdate(position: Int, message: Message) {
        messages[position] = message
        adapter.notifyItemChanged(position, message)
    }

    fun onMessageDeleted(position: Int) {
        messages.removeAt(position)
        adapter.notifyItemRemoved(position)
    }
}