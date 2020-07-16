package com.example.afia.ui.maps

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.afia.R
import com.example.afia.data.HospitalLocation
import com.example.afia.data.HospitalData
import com.example.afia.ui.reservation.ReservationActivity
import kotlinx.android.synthetic.main.hospital_map_item.view.*


class MapAdapter(val context : Context ,val onClickListner: OnClickListner )  :
        ListAdapter<HospitalData,MapAdapter.ViewHolder>(mapHospitalsDiffCallback()){

    interface OnClickListner{
        fun hospitl_click(mapLocation: HospitalLocation , itemPosition : Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.hospital_map_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val hospital = getItem(position)
        holder.itemView.hospital_logo.setOnClickListener{

            onClickListner.hospitl_click(hospital.location , position)

            val layoutParams = it.getLayoutParams()
            if (it.reserveNowBtn.visibility != View.GONE){
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT
                layoutParams.width  = ViewGroup.LayoutParams.MATCH_PARENT
                it.reserveNowBtn.visibility = View.GONE
            }else{
                layoutParams.width  = ViewGroup.LayoutParams.MATCH_PARENT
                it.reserveNowBtn.visibility = View.VISIBLE

            }
            it.setLayoutParams(layoutParams)

        }

        holder.bind(hospital)

    }
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind(hospital : HospitalData){
            itemView.hospitalName.text = hospital.name

            itemView.reserveNowBtn.setOnClickListener {
                val intent = Intent(itemView.context,ReservationActivity::class.java)
                itemView.context.startActivity(intent)

            }
        }
    }
}


class mapHospitalsDiffCallback : DiffUtil.ItemCallback<HospitalData>(){
    override fun areItemsTheSame(oldItem: HospitalData, newItem: HospitalData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: HospitalData, newItem: HospitalData): Boolean {
        return oldItem == newItem
    }

}