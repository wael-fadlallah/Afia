package com.example.afia.ui.hospitals

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.afia.R
import com.example.afia.ui.maps.HospitalsSearchActivity
import kotlinx.android.synthetic.main.fragment_hospitals.*
import kotlinx.android.synthetic.main.fragment_hospitals.view.*
import kotlinx.android.synthetic.main.fragment_hospitals.view.hospitalsSearchInput

/**
 * A simple [Fragment] subclass.
 */
class HospitalsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_hospitals, container, false)

        view.hospitals_recyclerView.adapter = hospitalsAdapter(this)

        view.hospitalsSearchInput.setOnClickListener {
            val intent = Intent(context, HospitalsSearchActivity::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return view
    }

}
