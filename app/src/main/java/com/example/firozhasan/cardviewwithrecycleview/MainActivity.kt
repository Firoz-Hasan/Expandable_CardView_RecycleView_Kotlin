package com.example.firozhasan.cardviewwithrecycleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar

class MainActivity : AppCompatActivity() {

    var dataModelList: ArrayList<DataModel> = ArrayList()
    var horizontalDataModelList: ArrayList<DataModelHorizontal> = ArrayList()
    var dataAdapter: DataAdapter? = null
    var dataAdapterHorizontal: DataAdapterHorizontal? = null
    var recyclerView: RecyclerView? = null
    var recyclerViewHorizontal: RecyclerView? = null
    var toolbarcard: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.test_sayem)

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
}
