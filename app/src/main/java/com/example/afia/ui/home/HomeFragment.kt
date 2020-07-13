package com.example.afia.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.example.afia.R
import com.example.afia.databinding.FragmentHomeBinding
import com.example.afia.ui.maps.HospitalsSearchActivity
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * A simple [Fragment] subclass.
 */

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding : FragmentHomeBinding  = DataBindingUtil.inflate(inflater , R.layout.fragment_home,container,false)
        binding.lifecycleOwner = this

        val view = binding.root

        view.hospitals_box?.setOnClickListener {
              NavHostFragment.findNavController(this).navigate(R.id.mainToHospitals)
//            val intent = Intent(context, HospitalsSearchActivity::class.java)
//            startActivity(intent)
        }

        view.notificationBox.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_notificationFragment)
        }

        view.offersBox.setOnClickListener {
            NavHostFragment.findNavController(this).navigate(R.id.action_homeFragment_to_offersFragment)
        }


        // Inflate the layout for this fragment
        return view
    }

}
