package com.example.afia.ui.extensions

import android.content.Context
import android.widget.Toast

class helpers {


    fun showToast(context: Context , msg : String){
        return Toast.makeText(context , msg  , Toast.LENGTH_LONG).show()
    }


}