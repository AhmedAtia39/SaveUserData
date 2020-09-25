package com.example.task.model

import android.annotation.SuppressLint
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.task.R

@SuppressLint("NewApi")
@BindingAdapter("onFocusChange")
fun EditText.onFocusChange(lable: TextView) {
    this.setOnFocusChangeListener { v, hasFocus ->
        if (hasFocus) {
            this.background = this.context.getDrawable(R.drawable.style_stroke_red)
            lable.setTextColor(this.context.getColor(R.color.red))
        } else {
            this.background = this.context.getDrawable(R.drawable.style_stroke_gray)
            lable.setTextColor(this.context.getColor(R.color.gray))
        }
    }
}
