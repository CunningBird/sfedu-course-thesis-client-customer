package com.cunningbird.thesis.client.customer.main.view.chats.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.cunningbird.thesis.client.customer.R
import com.cunningbird.thesis.client.customer.databinding.FragmentChatsListBinding
import com.cunningbird.thesis.client.customer.main.view.MainActivity

class ChatsListFragment : Fragment() {

    private lateinit var binding: FragmentChatsListBinding

    val viewModel: ChatsListViewModel by viewModels()

    private lateinit var adapter: ChatsListAdapter

    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity = (activity as MainActivity)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setViews()
    }

    private fun setViews() {
        mainActivity.changeToolbar(getString(R.string.your_messages),false)
        setAdapter()
    }

    private fun setAdapter() {
        adapter = ChatsListAdapter(this::onServiceClick)
        binding.rvMessages.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        binding.rvMessages.adapter = adapter
        adapter.list= listOf("hello","world")
    }

    private fun setListeners() {

    }

    private fun onServiceClick(i:Int){
        //todo передавать информацию через bundle
        val arg= bundleOf()
        findNavController().navigate(R.id.action_chatsListFragment_to_ChatsDialogFragment,arg)
    }

}