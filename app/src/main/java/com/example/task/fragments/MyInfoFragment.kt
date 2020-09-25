package com.example.task.fragments

import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.util.Consumer
import androidx.databinding.DataBindingUtil
import com.example.task.R
import com.example.task.UserModel
import com.example.task.databinding.FragmentMyInfoBinding
import com.google.gson.Gson

class MyInfoFragment : BaseFragment() {
    lateinit var  binding: FragmentMyInfoBinding
    lateinit var model: UserModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_info, container, false)
        model = UserModel()
        binding.model=model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            var user = Gson().fromJson(shared.userInfo, UserModel::class.java)
               model.name = user.name
               model.age = user.age
               model.job = user.job
               model.gender = user.gender

        binding.logout.setOnClickListener {
            context?.let { it1 -> dialogLogout(it1, Consumer {
                if (it) {
                    shared.setUserLogin(false)
                    navController.navigate(R.id.action_myInfoFragment_to_registerFragment)
                }
            }) }
        }

        binding.txtDisplayAll.setPaintFlags( binding.txtDisplayAll.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

        binding.txtDisplayAll.setOnClickListener {
            navController.navigate(R.id.action_myInfoFragment_to_allUsersFragment)
        }

    }
}