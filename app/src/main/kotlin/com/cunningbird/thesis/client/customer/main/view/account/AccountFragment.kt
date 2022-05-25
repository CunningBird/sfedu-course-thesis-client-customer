package com.cunningbird.thesis.client.customer.main.view.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.cunningbird.thesis.client.customer.databinding.FragmentAccountBinding
import com.cunningbird.thesis.client.customer.main.domain.repository.BackendRepository
import com.cunningbird.thesis.client.customer.main.view.FragmentViewModelFactory
import com.cunningbird.thesis.client.customer.main.view.MainActivity

class AccountFragment : Fragment() {

    private lateinit var binding: FragmentAccountBinding

    private val viewModel: AccountViewModel by viewModels {
        FragmentViewModelFactory(
            mainActivity.application,
            mainActivity.viewModel.backendRepository,
            BackendRepository::class.java
        )
    }

    private lateinit var mainActivity: MainActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        mainActivity = (activity as MainActivity)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity.changeToolbar("Your Account", false)

        binding.tvServiceName.text = viewModel.getUserName()
    }
}