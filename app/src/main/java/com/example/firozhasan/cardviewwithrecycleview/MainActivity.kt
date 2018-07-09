package com.example.firozhasan.cardviewwithrecycleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import com.danielme.android.cardview.ExpandAndCollapseViewUtil
import kotlinx.android.synthetic.main.applicants_list.*

class MainActivity : AppCompatActivity() {
    private val DURATION = 200
    var expandimageview : ImageView? = null
    var dataModelList: ArrayList<DataModel> = ArrayList()
    var horizontalDataModelList: ArrayList<DataModelHorizontal> = ArrayList()
    var dataAdapter: DataAdapter? = null
    var dataAdapterHorizontal: DataAdapterHorizontal? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewHorizontal: RecyclerView? = null
    var toolbarcard: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        expandimageview = findViewById(R.id.imageViewExpand)
//        expandimageview?.setOnClickListener {
//            toggleDetails()
//
//        }

        recyclerView = findViewById(R.id.recyclerview)
        recyclerViewHorizontal = findViewById(R.id.horizontalRecyclerview)

        dataAdapter = DataAdapter(dataModelList!!, applicationContext)
        dataAdapterHorizontal = DataAdapterHorizontal(horizontalDataModelList, applicationContext)

        recyclerView!!.adapter = dataAdapter
        recyclerView!!.setHasFixedSize(true)

        recyclerViewHorizontal!!.adapter = dataAdapterHorizontal
        recyclerViewHorizontal!!.setHasFixedSize(true)

        val layoutManagerHoriztal = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        val layoutManagerVertical = LinearLayoutManager(applicationContext)

        recyclerView!!.setLayoutManager(layoutManagerVertical)
        recyclerViewHorizontal!!.setLayoutManager(layoutManagerHoriztal)



        prepareData()
        prepareHoriData()
    }

    private fun prepareData() {
        var dm1 = DataModel("live", "100", "blablabla")
        dataModelList!!.add(dm1)

        var dm11 = DataModel("dead", "160", "eee\n" +
                "fsjdjhbkjfg\n" +
                "kkakaooeeeeeee")
        dataModelList!!.add(dm11)

        var dm12 = DataModel("khakha", "94", "wwwwwwwwwwww\ndbfkjgfsjkdf\nfsjdjhbkjfg\nkkakaoo")
        dataModelList!!.add(dm12)

        var dm13 = DataModel("qqqq", "4141", "qqqqqqqq")
        dataModelList!!.add(dm13)

        var dm14 = DataModel("live", "100", "blablabla")
        dataModelList!!.add(dm14)

        var dm15 = DataModel("dead", "160", "eeeeeeeeee")
        dataModelList!!.add(dm15)

        var dm16 = DataModel("khakha", "94", "wwwwwwwwwwww")
        dataModelList!!.add(dm16)

        var dm17 = DataModel("qqqq", "4141", "qqqqqqqq")
        dataModelList!!.add(dm17)

        var dm18 = DataModel("qqqq", "4141", "qqqqqqqq")
        dataModelList!!.add(dm18)

        var dm19 = DataModel("dead", "160", "eeeeeeeeee")
        dataModelList!!.add(dm19)

        var dm110 = DataModel("khakha", "94", "wwwwwwwwwwww")
        dataModelList!!.add(dm110)

        var dm111 = DataModel("qqqq", "4141", "qqqqqqqq")
        dataModelList!!.add(dm111)

        var dm112 = DataModel("qqqq", "4141", "qqqqqqqq")
        dataModelList!!.add(dm112)




    }

    private fun prepareHoriData() {

        var dm1 = DataModelHorizontal("live")
        horizontalDataModelList!!.add(dm1)
        var dm11 = DataModelHorizontal("bbb")
        horizontalDataModelList!!.add(dm11)
        var dm12 = DataModelHorizontal("live")
        horizontalDataModelList!!.add(dm12)
        var dm13 = DataModelHorizontal("bbb")
        horizontalDataModelList!!.add(dm13)
        var dm14 = DataModelHorizontal("live")
        horizontalDataModelList!!.add(dm14)
        var dm15 = DataModelHorizontal("bbb")
        horizontalDataModelList!!.add(dm15)
        var dm16 = DataModelHorizontal("live")
        horizontalDataModelList!!.add(dm16)
        var dm17 = DataModelHorizontal("bbb")
        horizontalDataModelList!!.add(dm17)
        var dm18 = DataModelHorizontal("live")
        horizontalDataModelList!!.add(dm18)
        var dm19 = DataModelHorizontal("bbb")
        horizontalDataModelList!!.add(dm19)
        var dm111 = DataModelHorizontal("live")
        horizontalDataModelList!!.add(dm111)
        var dm112 = DataModelHorizontal("bbb")
        horizontalDataModelList!!.add(dm112)

    }

//    fun toggleDetails(holder: MyViewHolder) {
//        var visibility: Int = holder.moreActionDetails!!.visibility
//
//        if (visibility == View.GONE) {
//            visibility = View.VISIBLE
//            Log.d("debugg", "iftoggleDetails: $visibility")
//            ExpandAndCollapseViewUtil.expand(holder.moreActionDetails!!, DURATION)
//            holder.imageViewExpand!!.setImageResource(R.drawable.ic_arrow_downward)
//            rotate(180.0f, holder)
//        } else {
//            ExpandAndCollapseViewUtil.collapse(holder.moreActionDetails!!, DURATION)
//            Log.d("debugg", "elsetoggleDetails: $visibility")
//            holder.imageViewExpand!!.setImageResource(R.drawable.ic_arrow_upward)
//            rotate(-180.0f, holder)
//        }
//    }
//
//    private fun rotate(angle: Float, holder: MyViewHolder) {
//        val animation = RotateAnimation(0.0f, angle, Animation.RELATIVE_TO_SELF, 0.5f,
//                Animation.RELATIVE_TO_SELF, 0.5f)
//        animation.fillAfter = true
//        animation.duration = DURATION.toLong()
//        holder.imageViewExpand!!.startAnimation(animation)
//    }
}
