package com.example.afia.ui.maps

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.afia.R
import com.example.afia.ui.data.HospitalLocation
import com.example.afia.ui.data.MapHospitalsData
import kotlinx.android.synthetic.main.hospital_map_item.view.*


class MapAdapter(val context : Context ,val onClickListner: OnClickListner )  :
        ListAdapter<MapHospitalsData,MapAdapter.ViewHolder>(mapHospitalsDiffCallback()){

    interface OnClickListner{
        fun hospitl_click(mapLocation: HospitalLocation , itemPosition : Int)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.hospital_map_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = getItem(position)
        holder.itemView.hospital_logo.setOnClickListener{

            onClickListner.hospitl_click(location.location , position)

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

            //

//            fun hideAllBut(itemId: Char) {
//                currentList.iterator().apply {
//                    while (hasNext()) next().apply {
//                        if (id != itemId) currentList.indexOf(this).also {
//                            layout.recycler.getChildAt(it).visibility = View.GONE
//                            layout.recycler.adapter?.notifyItemChanged(it)
//                        } } }
//            }

//            linearLayoutManager.scrollToPositionWithOffset(2, 20)


        }

    }
    class ViewHolder(v : View) : RecyclerView.ViewHolder(v){
    }

}


class mapHospitalsDiffCallback : DiffUtil.ItemCallback<MapHospitalsData>(){
    override fun areItemsTheSame(oldItem: MapHospitalsData, newItem: MapHospitalsData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: MapHospitalsData, newItem: MapHospitalsData): Boolean {
        return oldItem == newItem
    }

}