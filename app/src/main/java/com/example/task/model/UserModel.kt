package com.example.task

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable

class UserModel : BaseObservable() {

    @get:Bindable
    var name: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.name)
        }
    @get:Bindable
    var age: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.age)
        }
    @get:Bindable
    var job: String? = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.job)
        }

    // 1 male   2 female
    @get:Bindable
    var gender: Int? = 1
        set(value) {
            field = value
            notifyPropertyChanged(BR.gender)
        }
}