package com.example.afia.extensions

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    fun toast(msg : String){
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }
}