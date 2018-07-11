package com.example.firozhasan.cardviewwithrecycleview

import android.content.Context
import android.os.Build
import android.support.annotation.IntegerRes
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.danielme.android.cardview.ExpandAndCollapseViewUtil
import com.example.firozhasan.cardviewwithrecycleview.R.id.imageViewExpand
import java.lang.Boolean.TRUE


class DataAdapterHorizontal(val items: ArrayList<DataModelHorizontal>, val context: Context) : RecyclerView.Adapter<DataAdapterHorizontal.MyViewHolderHorizontal>() {

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolderHorizontal, position: Int) {
//
        var dModel = items.get(position)
        holder.application.text = dModel.application

        holder.application.setOnClickListener {

            holder.application.background = 

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderHorizontal {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_data_horizontal_view, parent, false)
        return DataAdapterHorizontal.MyViewHolderHorizontal(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    class MyViewHolderHorizontal(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var application: TextView = itemView!!.findViewById(R.id.application_TV)

    }
}