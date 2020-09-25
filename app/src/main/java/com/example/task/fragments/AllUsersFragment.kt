package com.example.task.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.task.R
import com.example.task.adapter.AllUsersAdapter
import com.example.task.databinding.FragmentAllUsersBinding

class AllUsersFragment : BaseFragment() {

    lateinit var adapter: AllUsersAdapter
    lateinit var binding:FragmentAllUsersBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_all_users, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var arr = shared.allUsers
        adapter = AllUsersAdapter(arr, context)
        binding.rvAllusers.setHasFixedSize(true)
        var layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.rvAllusers.layoutManager = layoutManager
        binding.rvAllusers.adapter = adapter


        binding.imgClose.setOnClickListener {
            navController.popBackStack()
        }
    }
}