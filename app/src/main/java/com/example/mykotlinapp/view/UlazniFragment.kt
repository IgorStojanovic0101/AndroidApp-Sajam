package com.example.mykotlinapp.view
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.mykotlinapp.contract.MainActivityContract

import kotlinx.android.synthetic.main.main.*
import android.app.Activity

import com.example.mykotlinapp.model.MainActivityModel
import com.example.mykotlinapp.presenter.UlazniPresenter

import android.content.Intent
import android.content.IntentFilter



import com.example.mykotlinapp.R


import android.content.BroadcastReceiver

import android.content.Context

import com.example.mykotlinapp.contract.OnHeadlineSelectedListener
import org.json.JSONObject











class UlazniFragment : Fragment(),MainActivityContract.UlazniView{

    private lateinit var callback : OnHeadlineSelectedListener
    private lateinit var mPresenter: MainActivityContract.UlazniPresenter
    private lateinit var activity: Activity
    private lateinit var model:MainActivityModel
    private lateinit var  broadcastReceiver: BroadcastReceiver



    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity= this.getActivity()!!

      //  val args =arguments
        //val personJsonString = args!!.get("data_key") as String

        //   model= Utils.gsonParser()!!.fromJson(personJsonString, MainActivityModel::class.java)

        mPresenter = UlazniPresenter(this)

    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):View
    {

        var retView  = inflater.inflate(R.layout.main, container, false)


        return retView
    }

    override fun initView() {
        custom_signup_button.setOnClickListener {
            mPresenter.noviFragment(activity)
        }
        custom_signin_button.setOnClickListener {
            mPresenter.Login(activity)
            registerReceiver()
        }

        sign_out.setOnClickListener {



        }

    }
    override fun getTextFromUsername(): String {
        return username.text.toString()
    }
    override fun getTextFromPassword():String
    {
        return password_edittext.text.toString()
    }

    override fun setViewData(data: String) {
     //username.setText(model.data)

    }

    override  fun setName(data: String) {
        username.setText(data)

    }


    override  fun setPassword(data: String)
    {
        password_edittext.setText(data)
    }

    private fun registerReceiver() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val otpCode = intent.getStringExtra("serviceData")
                val JO =  JSONObject(otpCode)
                val username = JO.getString("username")
                val ime= JO.getString("ime")
                val prezime=JO.getString("prezime")
                callback.onArticleSelected(username,ime,prezime)

//                model.username=username
            //    val data= Utils.gsonParser()?.toJson(model)
            //    val bundle=Bundle()
            //    bundle.putString("data_key",data)
           //mPresenter.UlazUmenuActivity(activity,username,ime,prezime)




            }
        }
        activity.registerReceiver(broadcastReceiver, IntentFilter("login_rec"))
    }
    fun setOnHeadlineSelectedListener(callback: OnHeadlineSelectedListener) {
         this.callback = callback
    }




}
