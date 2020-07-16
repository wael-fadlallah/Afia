package com.example.afia.ui.hospitals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.afia.R
import com.example.afia.data.HospitalData
import kotlinx.android.synthetic.main.hospital_recycler_item.view.*


class hospitalsAdapter(private val fragment:HospitalsFragment, val hospitals: ArrayList<HospitalData>? = null) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hospital_recycler_item,parent,false)

        return hospitalViewHolder(view)
    }

    override fun getItemCount(): Int = hospitals!!.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val hospital = hospitals?.get(position)
        holder.itemView.setOnClickListener {
            fragment.findNavController().navigate(R.id.action_hospitalsFragment_to_hospitalDetalisFragment)
        }

//        todo fix hospital name length bug
//        holder.itemView.hospitalname.text = hospital?.name
    }
    class hospitalViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }
}

