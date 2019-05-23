package com.example.mykotlinapp.services

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import android.widget.Toast
import com.example.mykotlinapp.R
import com.example.mykotlinapp.contract.MainActivityContract
import kotlinx.android.synthetic.main.admin_layout.*
import kotlinx.android.synthetic.main.main.view.*
import java.util.*
import android.support.v4.app.NotificationCompat.getExtras
import android.os.Bundle


open class TestReceiver : BroadcastReceiver() {

  lateinit var data: String
    lateinit var view:MainActivityContract.UlazniView

    override fun onReceive(context: Context?, cellerIntent: Intent?) {

      // val serviceData= cellerIntent?.getStringExtra("serviceData")
       // val servicePassword = cellerIntent?.getStringExtra("password")
     //   Log.e("Main",serviceData+"receiving data"+SystemClock.elapsedRealtime())
       // val now = "\n"+serviceData+"---"+ Date().toString()









    }

}