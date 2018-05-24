package com.example.firozhasan.cardviewwithrecycleview

import android.content.Context
import android.os.Build
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
import com.danielme.android.cardview.ExpandAndCollapseViewUtil
import com.example.firozhasan.cardviewwithrecycleview.R.id.imageViewExpand
import java.lang.Boolean.TRUE


class DataAdapter(val items: ArrayList<DataModel>, val context: Context) : RecyclerView.Adapter<MyViewHolder>() {

    private val DURATION = 200

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_data_view, parent, false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    @RequiresApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        var dModel = items[position]
        holder.jstatus.text = dModel.jobStatus
        holder.application.text = dModel.application
        holder.more.text = dModel.more
        //holder.moreActionDetails!!

        holder.moreAction!!.setOnClickListener {
            Log.d("click", "clicked success")
            toggleDetails(holder)
        }



    }

    fun toggleDetails(holder: MyViewHolder) {
        var visibility: Int = holder.moreActionDetails!!.visibility

        if (visibility == View.GONE) {
            visibility = View.VISIBLE
            Log.d("debugg", "iftoggleDetails: $visibility")
            ExpandAndCollapseViewUtil.expand(holder.moreActionDetails!!, DURATION)
            holder.imageViewExpand!!.setImageResource(R.drawable.ic_arrow_downward)
            rotate(180.0f, holder)
        } else {
            ExpandAndCollapseViewUtil.collapse(holder.moreActionDetails!!, DURATION)
            Log.d("debugg", "elsetoggleDetails: $visibility")
            holder.imageViewExpand!!.setImageResource(R.drawable.ic_arrow_upward)
            rotate(-180.0f, holder)
        }
    }

    private fun rotate(angle: Float, holder: MyViewHolder) {
        val animation = RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)
        animation.fillAfter = true
        animation.duration = DURATION.toLong()
        holder.imageViewExpand!!.startAnimation(animation)
    }
}