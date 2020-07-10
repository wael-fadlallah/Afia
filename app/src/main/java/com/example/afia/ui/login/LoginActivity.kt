package com.example.afia.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.afia.R
import com.example.afia.ui.dashboard.Dashboard
import com.example.afia.databinding.ActivityLoginBinding
import com.example.afia.ui.sginup.SginUpActivity

class LoginActivity : AppCompatActivity() {

//    lateinit var binding :
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val loginViewModel : LoginViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.loginViewModel = loginViewModel


        // the logic
        binding.materialButton2.setOnClickListener {
            loginViewModel.login()
        }

        loginViewModel.loginBtnClicked.observe( this, Observer {
            if(it) {
                Toast.makeText(this, "login button click !", Toast.LENGTH_LONG).show()

                val intent = Intent(this,Dashboard::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                startActivity(intent)
            }
        })

        loginViewModel.signupBtnClicked.observe(this, Observer {
            if (it){
                val intent = Intent(this,SginUpActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        })



        // todo : use textViewLayout error
    }
}
