package com.example.afia.ui.sginup

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SginViewModel : ViewModel() {

    val sginupBtnClick = MutableLiveData<Boolean>()
    val loginTextclick = MutableLiveData<Boolean>()

    fun sginup(){
        sginupBtnClick.value = true
    }

    fun goToLogin(){
        loginTextclick.value = true
    }


}