package com.eya_nasri.think_itchallenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.ParsePosition

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(){

    private val roomNames = arrayOf("Living Room", "Media Room","Bathroom", "Bedroom" )
    private val roomNumberDevices = arrayOf("4 Devices", "6 Devices", "1 Device", "3 Devices")
    private val roomImages = intArrayOf(
        R.drawable.livingroom,
        R.drawable.mediaroom,
        R.drawable.bathroom,
        R.drawable.bedroom
    )

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView){
        var roomImage : ImageView
        var roomName : TextView
        var numberOfDevices : TextView

        init {
            roomImage = itemView.findViewById(R.id.room_image)
            roomName = itemView.findViewById(R.id.room_name)
            numberOfDevices = itemView.findViewById(R.id.room_number_devices)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
        val  v: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.recyclerview_module, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int ){
        holder.roomName.text = roomNames[position]
        holder.numberOfDevices.text = roomNumberDevices[position]
        holder.roomImage.setImageResource(roomImages[position])
    }

    override fun getItemCount(): Int {
        return roomNames.size
    }
}