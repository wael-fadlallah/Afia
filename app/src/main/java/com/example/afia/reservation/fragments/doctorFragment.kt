package com.example.afia.reservation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.afia.R
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_doctor.view.*

/**
 * A simple [Fragment] subclass.
 */
class doctorFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_doctor, container, false)

        view.nextBtn.setOnClickListener {
            activity?.findViewById<TabLayout>(R.id.tabLayout)?.getTabAt(2)?.select()
        }

        // Inflate the layout for this fragment
        return view
    }

}
