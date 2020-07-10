package com.example.afia.ui.reservation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.afia.ui.reservation.fragments.paymentFragment
import com.example.afia.ui.reservation.fragments.doctorFragment
import com.example.afia.ui.reservation.fragments.patientFragment
import com.example.afia.ui.reservation.fragments.reservationDetailsFragment

internal class PagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm!!){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> patientFragment()
            1 -> doctorFragment()
            2 -> reservationDetailsFragment()
            3 -> paymentFragment()
            else -> patientFragment()
        }
    }

    override fun getCount(): Int = 5

}