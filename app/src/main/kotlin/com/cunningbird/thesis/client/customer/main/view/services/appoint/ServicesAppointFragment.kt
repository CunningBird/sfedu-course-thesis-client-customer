package com.cunningbird.thesis.client.customer.main.view.services.appoint

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class ServicesAppointFragment : Fragment() {
    //todo xml
//    private lateinit var binding: ServiceInfoBinding
    val viewModel: ServicesAppointViewModel by viewModels()

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View {
//        binding = ServiceInfoBinding.inflate(inflater, container, false)
//        return binding.root
//    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setViews()
    }

    private fun setViews() {

    }

    private fun setListeners() {

    }
}