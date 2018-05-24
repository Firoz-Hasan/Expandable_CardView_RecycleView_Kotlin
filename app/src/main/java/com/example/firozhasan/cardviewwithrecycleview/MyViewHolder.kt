package com.example.firozhasan.cardviewwithrecycleview

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var moreActionDetails: ViewGroup? = itemView!!.findViewById(R.id.linearLayoutDetails)
    var moreAction: LinearLayout? = itemView!!.findViewById(R.id.moreLL)
    var imageViewExpand: ImageView? = itemView!!.findViewById(R.id.imageViewExpand) as ImageView

    var jstatus: TextView = itemView!!.findViewById(R.id.tv_status)
    var application: TextView = itemView!!.findViewById(R.id.tv_application)
    var more: TextView = itemView!!.findViewById(R.id.tv_more)
  //  var moreDetails: ViewGroup = itemView!!.findViewById(R.id.linearLayoutDetails)


}