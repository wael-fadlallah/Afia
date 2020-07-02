package com.example.afia.maps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.afia.R
import com.example.afia.data.HospitalLocation
import com.example.afia.data.MapHospitalsData
import kotlinx.android.synthetic.main.hospital_map_item.view.*

class MapAdapter(val context : Context ,val data : ArrayList<MapHospitalsData> ,val onClickListner: OnClickListner )  : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    interface OnClickListner{
        fun hospitl_click(mapLocation: HospitalLocation)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.hospital_map_item,parent,false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val location = data[position].location
        holder.itemView.hospital_logo.setOnClickListener{
            onClickListner.hospitl_click(location)
        }

    }

}

class ViewHolder(v : View) : RecyclerView.ViewHolder(v){

}