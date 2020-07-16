package com.example.afia.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.afia.MainActivity

class LoginViewModel : ViewModel() {

    val loginBtnClicked  = MutableLiveData<Boolean>()
    val signupBtnClicked = MutableLiveData<Boolean>()

    init {
//        Toast.makeText(getApplication(),"Init",Toast.LENGTH_LONG).show()
    }

    fun login(){
//        Log.i(MainActivity.TAG,"CLICK")
        loginBtnClicked.value = true
    }

    fun signupBtn(){
        signupBtnClicked.value = true
    }

}