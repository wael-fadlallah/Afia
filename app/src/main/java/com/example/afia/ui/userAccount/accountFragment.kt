package com.example.afia.ui.userAccount

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter

import com.example.afia.R
import kotlinx.android.synthetic.main.fragment_account.view.*

/**
 * A simple [Fragment] subclass.
 */
class accountFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val layout = inflater.inflate(R.layout.fragment_account, container, false)

        val data = listOf<String>("test","test")
        layout.spinner.adapter = ArrayAdapter(layout.context,R.layout.support_simple_spinner_dropdown_item,data)

        // Inflate the layout for this fragment
        return layout
    }

}
