package com.example.afia.sginup

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.afia.R
import com.example.afia.databinding.ActivitySginUpBinding
import com.example.afia.extensions.BaseActivity
import com.example.afia.login.LoginActivity

class SginUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivitySginUpBinding = DataBindingUtil.setContentView(this,R.layout.activity_sgin_up)
        binding.lifecycleOwner = this
        val signupViewModel : SginViewModel by viewModels()
        binding.signupViewModel = signupViewModel

        signupViewModel.sginupBtnClick.observe(this , Observer {
            if (it){
                toast("sgin up ")
            }
        })

        signupViewModel.loginTextclick.observe(this, Observer {
            if (it){
                val intent = Intent(this,LoginActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        })


    }
}
