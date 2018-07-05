package com.example.firozhasan.cardviewwithrecycleview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.net.Uri


class SharingIntent : AppCompatActivity() {

    val shareButton: Button? = null
    val call: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sharing_intent)
        shareButton?.setOnClickListener {

            val dialer = Intent("android.intent.action.CALL_PRIVILEGED")
            dialer.data = Uri.parse("tel:65465446")
            var chooser: Intent? = null
            chooser = Intent.createChooser(dialer, "Select Dialing Software...")
            startActivity(chooser)
        }
    }
}
