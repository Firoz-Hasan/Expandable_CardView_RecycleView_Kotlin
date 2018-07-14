package com.example.firozhasan.cardviewwithrecycleview

import android.content.Context
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class DataAdapterHorizontal(val items: ArrayList<DataModelHorizontal>, val context: Context) : RecyclerView.Adapter<DataAdapterHorizontal.MyViewHolderHorizontal>() {

    var selectedPosition = -1

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN)
    override fun onBindViewHolder(holder: MyViewHolderHorizontal, position: Int) {
//
        var dModel = items.get(position)
        holder.number_Value.text = dModel.application
        holder.string_Value.text = dModel.value

        if(selectedPosition==position) {
            holder.number_Value.setBackgroundResource(R.drawable.circle1)
           // holder.number_Value.setTextColor(Color.parseColor("#F2F2F2"))
        }
        else
            holder.number_Value.setBackgroundResource(R.drawable.circle)


        holder.number_Value.setOnClickListener {
            selectedPosition=position
            notifyDataSetChanged()

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

        var number_Value: TextView = itemView!!.findViewById(R.id.number_TV)
        var string_Value: TextView = itemView!!.findViewById(R.id.value_TV)

    }
}