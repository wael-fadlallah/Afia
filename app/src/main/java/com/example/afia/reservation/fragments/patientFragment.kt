package com.example.afia.reservation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button

import com.example.afia.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_reservation.*
import kotlinx.android.synthetic.main.activity_reservation.view.*
import kotlinx.android.synthetic.main.fragment_patient.view.*

/**
 * A simple [Fragment] subclass.
 */
class patientFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_patient, container, false)

        val genders = listOf<String>("ذكر" , "انثى")

        view.spinner_gender.adapter = context?.let { ArrayAdapter(it,R.layout.support_simple_spinner_dropdown_item,genders) }

        view.nextBtn.setOnClickListener {
            val tab = activity?.findViewById<TabLayout>(R.id.tabLayout)
            tab?.getTabAt(1)?.select()
        }
        // Inflate the layout for this fragment
        return view
    }

}
