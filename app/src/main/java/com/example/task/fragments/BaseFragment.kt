package com.example.task.fragments

import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.util.Consumer
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.task.R
import com.example.task.model.SharedPref
import uk.co.chrisjenx.calligraphy.CalligraphyConfig

open class BaseFragment : Fragment() {

    lateinit var navController: NavController
    lateinit var shared:SharedPref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_all_users, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shared = SharedPref(context)
        navController = NavHostFragment.findNavController(this)
    }
    fun dialogError(
        context: Context,
        info_text: String,
        consumer: Consumer<Boolean>?
    ) {
        try {

            var dialog_msg = Dialog(context)
            dialog_msg.setContentView(R.layout.error_msg)
            dialog_msg.setCancelable(false)
            dialog_msg.setCanceledOnTouchOutside(false)

            dialog_msg.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog_msg.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            var info = dialog_msg.findViewById<TextView>(R.id.info)
            var done = dialog_msg.findViewById<TextView>(R.id.done)

            info.text = info_text

            done.setOnClickListener {
                dialog_msg.cancel()
                consumer?.accept(false)
            }

            dialog_msg.show()
        } catch (e: Exception) {

        }
    }

    fun dialogLogout(
        context: Context,
        consumer: Consumer<Boolean>?
    ) {
        try {

            var dialog_msg = Dialog(context)
            dialog_msg.setContentView(R.layout.logout)
            dialog_msg.setCancelable(false)
            dialog_msg.setCanceledOnTouchOutside(false)

            dialog_msg.window!!.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog_msg.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

            var done = dialog_msg.findViewById<TextView>(R.id.done)
            var no = dialog_msg.findViewById<TextView>(R.id.no)

            done.setOnClickListener {
                dialog_msg.cancel()
                consumer?.accept(true)
            }
            no.setOnClickListener {
                dialog_msg.cancel()
                consumer?.accept(false)
            }

            dialog_msg.show()
        } catch (e: Exception) {

        }
    }

}