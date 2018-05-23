package com.example.firozhasan.cardviewwithrecycleview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var jstatus: TextView = itemView!!.findViewById(R.id.tv_status)
    var application: TextView = itemView!!.findViewById(R.id.tv_application)
    var more: TextView = itemView!!.findViewById(R.id.tv_more)

}