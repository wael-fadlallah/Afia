package com.example.afia.hospitals

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.afia.R
import kotlinx.android.synthetic.main.fragment_hospitals.view.*

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
        // Inflate the layout for this fragment
        return view
    }

}
