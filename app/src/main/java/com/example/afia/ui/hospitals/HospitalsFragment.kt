package com.example.afia.ui.hospitals

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.afia.MainActivity
import com.example.afia.data.HospitalData
import com.example.afia.databinding.FragmentHospitalsBinding
import com.example.afia.ui.maps.HospitalsSearchActivity

/**
 * A simple [Fragment] subclass.
 */
class HospitalsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHospitalsBinding.inflate(inflater)
        val HospitalsViewModel : HospitalsViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.hospitalsViewModel = HospitalsViewModel

        val hospitals =  ArrayList<HospitalData>()
        val hospitalsAdapter = hospitalsAdapter(this,hospitals)

//        observer
        HospitalsViewModel.hospital.observe(viewLifecycleOwner , Observer {
            Log.i(MainActivity.TAG,"The data is loaded ${it}")
            if (it.success){
                hospitals.addAll(it.data)
                hospitalsAdapter.notifyDataSetChanged()
            }
        })

        binding.hospitalsRecyclerView.adapter = hospitalsAdapter

        binding.hospitalsSearchInput.setOnClickListener {
            val intent = Intent(context, HospitalsSearchActivity::class.java)
            startActivity(intent)
        }
        // Inflate the layout for this fragment
        return binding.root
    }

}
