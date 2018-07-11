package com.example.firozhasan.cardviewwithrecycleview

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.RecyclerView
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
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.content.ContextCompat.startActivity







class DataAdapterApplicationLists(val items: ArrayList<DataModelApplicants>, val context: Context) : RecyclerView.Adapter<DataAdapterApplicationLists.MyViewHolderApplicants>() {

    private val DURATION = 500
    private var call: Callback? = null

    init {
        call = context as Callback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolderApplicants {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.applicants_list, parent, false)
        return MyViewHolderApplicants(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: MyViewHolderApplicants, position: Int) {

        var dModel = items.get(position)
        holder.salary.text = dModel.salaryM
        holder.experience.text = dModel.experienceM
        holder.appliedOn.text = dModel.appliedOnM
        holder.university.text = dModel.universityM
        holder.company.text = dModel.companyM
        //holder.moreActionDetails!!

        holder.moreAction!!.setOnClickListener {
            Log.d("click", "clicked success")
            toggleDetails(holder)
        }

        var visibility: Int = holder.moreActionDetails!!.visibility
        Log.d("beforetoggle", "beforetoggleDetails: $visibility")
        holder.moreActionDetails?.visibility = View.GONE

        holder.callapplicants?.setOnClickListener {
            //startActivity(chooser)
            call?.onItemlick()
        }


    }

    fun toggleDetails(holder: MyViewHolderApplicants) {
        var visibility: Int = holder.moreActionDetails!!.visibility
      //  Log.d("beforetoggle", "beforetoggleDetails: $visibility")

        if (visibility == View.GONE) {
            visibility = View.VISIBLE
            Log.d("debugg", "iftoggleDetails: $visibility")
            ExpandAndCollapseViewUtil.expand(holder.moreActionDetails!!, DURATION)
            holder.imageViewExpand!!.setImageResource(R.drawable.ic_expand)

            rotate(180.0f, holder)
        } else {
            ExpandAndCollapseViewUtil.collapse(holder.moreActionDetails!!, DURATION)
            Log.d("debugg", "elsetoggleDetails: $visibility")

            holder.imageViewExpand!!.setImageResource(R.drawable.ic_expand_up)
            rotate(-180.0f, holder)
        }
    }

    private fun rotate(angle: Float, holder: MyViewHolderApplicants) {
        val animation = RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f)
        animation.fillAfter = true
        animation.duration = DURATION.toLong()
        holder.imageViewExpand!!.startAnimation(animation)
    }

    class MyViewHolderApplicants(itemView: View?) : RecyclerView.ViewHolder(itemView) {

        var moreActionDetails: ViewGroup? = itemView!!.findViewById(R.id.linearLayoutDetails)
        var moreAction: LinearLayout? = itemView!!.findViewById(R.id.moreLL)
        var callapplicants : ImageView? = itemView!!.findViewById(R.id.hotJobsIV)


        var imageViewExpand: ImageView? = itemView!!.findViewById(R.id.imageViewExpand) as ImageView

        var salary: TextView = itemView!!.findViewById(R.id.Salary_Result_TV)
        var experience: TextView = itemView!!.findViewById(R.id.Experience_Res_TV)
        var appliedOn: TextView = itemView!!.findViewById(R.id.appliedOn_Res_TV)
        var university:TextView = itemView!!.findViewById(R.id.univ_TV_res)
        var company:TextView = itemView!!.findViewById(R.id.company_TV_res)

        //  var moreDetails: ViewGroup = itemView!!.findViewById(R.id.linearLayoutDetails)


    }
}