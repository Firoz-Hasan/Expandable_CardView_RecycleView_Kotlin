package com.example.firozhasan.cardviewwithrecycleview

import android.app.ProgressDialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity(), Callback {


    internal var tv_callPerson: TextView? = null
    internal var tv_emailPerson: TextView? = null
    internal var tv_textPerson: TextView? = null
    internal var prgDialog: ProgressDialog? = null


    override fun onItemlick() {

        callsmsemailChooser()

    }

    private fun callsmsemailChooser() {
        val builder: android.app.AlertDialog.Builder
        val alertDialog: android.app.AlertDialog

        val linf = LayoutInflater.from(this@MainActivity)
        val inflator = linf.inflate(R.layout.callmsg, null)
        builder = android.app.AlertDialog.Builder(this@MainActivity)
        builder.setView(inflator)
        alertDialog = builder.create()
        InitViews(inflator, alertDialog)
        alertDialog.setCancelable(true)
        alertDialog.show()
    }

    private fun InitViews(inflator: View, alertDialog: android.app.AlertDialog) {

        tv_callPerson = inflator.findViewById(R.id.tv_title_up_cam) as TextView
        tv_emailPerson = inflator.findViewById(R.id.tv_title_up_fb) as TextView
        tv_textPerson = inflator.findViewById(R.id.tv_title_up_gall) as TextView


        prgDialog = ProgressDialog(this@MainActivity)
        prgDialog!!.setCancelable(false)

        // Setting up OnClickListener
        tv_callPerson!!.setOnClickListener(View.OnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:0123456789")
            startActivity(intent)
            alertDialog.dismiss()
        })
        tv_emailPerson!!.setOnClickListener(View.OnClickListener {
            //Toast.makeText(getActivity(), "clicked2!", Toast.LENGTH_SHORT).show();
            val mailto = "mailto:bob@example.org"

            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse(mailto)

            try {
                startActivity(emailIntent)
            } catch (e: ActivityNotFoundException) {
                //TODO: Handle case where no email app is available
            }


            alertDialog.dismiss()
        })
        tv_textPerson!!.setOnClickListener(View.OnClickListener {
            // Toast.makeText(getActivity(), "clicked3!", Toast.LENGTH_SHORT).show();
            val smsIntent = Intent(android.content.Intent.ACTION_VIEW)
            smsIntent.type = "vnd.android-dir/mms-sms"
            smsIntent.putExtra("address", "your desired phoneNumber")
            smsIntent.putExtra("sms_body", "your desired message")
            startActivity(smsIntent)
            alertDialog.dismiss()
        })
    }

    private val DURATION = 200
    var expandimageview: ImageView? = null
    var dataModelList: ArrayList<DataModel> = ArrayList()
    var horizontalDataModelList: ArrayList<DataModelHorizontal> = ArrayList()
    var dataModelApplicantsList: ArrayList<DataModelApplicants> = ArrayList()

    var dataAdapter: DataAdapter? = null
    var dataAdapterHorizontal: DataAdapterHorizontal? = null
    var dataAdapterApplicantsList: DataAdapterApplicationLists? = null

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

        //  dataAdapter = DataAdapter(dataModelList!!, applicationContext)
        dataAdapterApplicantsList = DataAdapterApplicationLists(dataModelApplicantsList, this@MainActivity)

        dataAdapterHorizontal = DataAdapterHorizontal(horizontalDataModelList, this@MainActivity)

        //  recyclerView!!.adapter = dataAdapter
        //  recyclerView!!.setHasFixedSize(true)

        recyclerView!!.adapter = dataAdapterApplicantsList
        recyclerView!!.setHasFixedSize(true)

        recyclerViewHorizontal!!.adapter = dataAdapterHorizontal
        recyclerViewHorizontal!!.setHasFixedSize(true)

        val layoutManagerHoriztal = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        val layoutManagerVertical = LinearLayoutManager(applicationContext)

        recyclerView!!.setLayoutManager(layoutManagerVertical)
        recyclerViewHorizontal!!.setLayoutManager(layoutManagerHoriztal)



        prepareData()
        prepareHoriData()
        prepareApplicantsList()
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

        for (i in 1..10) {
            var dm112 = DataModelHorizontal(i.toString(), "abcde")
            horizontalDataModelList!!.add(dm112)
        }


    }

    private fun prepareApplicantsList() {


        for (i in 1..10) {
            var dm1 = DataModelApplicants("aaa", "bbb", "bbb", "ddd", "eee")
            dataModelApplicantsList!!.add(dm1)
        }
    }


}
