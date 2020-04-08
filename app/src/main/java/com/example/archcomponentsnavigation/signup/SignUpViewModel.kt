package com.example.archcomponentsnavigation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.archcomponentsnavigation.User

class SignUpViewModel : ViewModel() {

    private val user = User()
    private val _liveData = MutableLiveData(user)
    val liveData: LiveData<User> = _liveData

    fun setName(name: String, lastName: String) {
        user.name = name
        user.lastName = lastName
        _liveData.value = user
    }

    fun setDescription(description: String) {
        user.description = description
        _liveData.value = user
    }
}