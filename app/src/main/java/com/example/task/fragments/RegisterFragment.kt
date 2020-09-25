package com.example.task.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.task.R
import com.example.task.UserModel
import com.example.task.databinding.FragmentRegisterBinding
import com.google.gson.Gson

class RegisterFragment : BaseFragment() {

    lateinit var  binding:FragmentRegisterBinding
    lateinit var model: UserModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_register, container, false)
        model = UserModel()
        binding.model=model
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.male.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                model.gender=1
            else
                model.gender=2
        }
        binding.female.setOnCheckedChangeListener { compoundButton, b ->
            if (b)
                model.gender=2
            else
                model.gender=1
        }

        binding.btnSave.setOnClickListener{
            saveData()
        }
    }
    private fun saveData() {
        if (model.name!!.length==0)
            context?.let { dialogError(it,getString(R.string.please_write_name),null) }
        else if (model.age!!.length==0)
            context?.let { dialogError(it,getString(R.string.please_write_age),null) }
        else if (model.job!!.length==0)
            context?.let { dialogError(it,getString(R.string.please_write_job),null) }
        else
        {
            var user = Gson().toJson(model)
            shared.setUserinfo(user)
            shared.saveUserObject(model)
            shared.setUserLogin(true)
            navController.popBackStack(R.id.registerFragment, true)
            navController.navigate(R.id.myInfoFragment)
        }
    }
}