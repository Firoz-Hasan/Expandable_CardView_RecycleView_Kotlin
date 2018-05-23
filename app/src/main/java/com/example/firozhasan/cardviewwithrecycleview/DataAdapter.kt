package com.example.firozhasan.cardviewwithrecycleview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.LinearLayout


class DataAdapter(val items: List<DataModel>, val context: Context) : RecyclerView.Adapter<MyViewHolder>() {
    var moreAction : LinearLayout? = null
    var toolbarCard : Toolbar? = null
    private val DURATION = 250

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.custom_data_view, parent, false)
        toolbarCard = itemView.findViewById(R.id.toolbar)
        toolbarCard!!.setTitle("Java Developer")
        moreAction = itemView.findViewById(R.id.moreLL)
        moreAction!!.setOnClickListener{
            toggleDetails()
            //ExpandAndCollapseViewUtil.expand(moreAction!!, DURATION)
        }

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
      return items.size
        }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var dModel = items.get(position)
        holder.jstatus.text=dModel.jobStatus
        holder.application.text=dModel.application
        holder.more.text = dModel.more


    }

    fun toggleDetails() {
        if (moreAction!!.getVisibility() == View.VISIBLE) {
            ExpandAndCollapseViewUtil.expand(moreAction!!, DURATION)
         //   imageViewExpand.setImageResource(R.mipmap.more)
            rotate(-180.0f)
        } else {
            ExpandAndCollapseViewUtil.collapse(moreAction!!, DURATION)
         //   imageViewExpand.setImageResource(R.mipmap.less)
            rotate(180.0f)
        }
    }

    private fun rotate(angle: Float) {
        val animation = RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)
        animation.fillAfter = true
        animation.duration = DURATION.toLong()

     //   imageViewExpand.startAnimation(animation)
    }
}