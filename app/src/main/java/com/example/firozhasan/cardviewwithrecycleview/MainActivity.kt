package com.example.firozhasan.cardviewwithrecycleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar

class MainActivity : AppCompatActivity() {

    var dataModelList: ArrayList<DataModel> = ArrayList()
    var dataAdapter: DataAdapter?= null
    var recyclerView: RecyclerView?=null
    var toolbarcard : Toolbar?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        dataAdapter = DataAdapter(dataModelList!!, applicationContext)
        recyclerView!!.adapter = dataAdapter
        recyclerView!!.setHasFixedSize(true)

        val layoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.setLayoutManager(layoutManager)
        prepareData()
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

    }
}
