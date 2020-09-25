package com.example.task.fragments

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task.R


class SplashFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController.popBackStack(R.id.splashFragment, true)
        Handler().postDelayed({
            if (shared.userIsLogin())
                navController.navigate(R.id.myInfoFragment)
            else
                navController.navigate(R.id.registerFragment)
        }, 3000)
    }
}