package com.example.mykotlinapp.presenter

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.util.Log
import android.widget.Toast
import com.example.mykotlinapp.R
import com.example.mykotlinapp.contract.MainActivityContract
import com.example.mykotlinapp.services.Login_Service

import com.example.mykotlinapp.view.SignUpFragment


class UlazniPresenter(private val mView: MainActivityContract.UlazniView) : MainActivityContract.UlazniPresenter {



    override fun noviFragment(activity: Activity) {
        var newFragment = SignUpFragment()
        val fm = (activity as FragmentActivity).supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.setCustomAnimations(R.anim.abc_slide_in_top,R.anim.abc_slide_out_bottom,R.anim.abc_slide_in_top,R.anim.abc_slide_out_bottom)
        fragmentTransaction.replace(R.id.myContainer, newFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }


    override fun Login(activity: Activity)
    {
        val username=mView.getTextFromUsername()
        val password=mView.getTextFromPassword()

       //val Service = Intent("services.Login_Service")
        val serviceIntent = Intent(activity, Login_Service::class.java)
        serviceIntent.putExtra("username", username)
        serviceIntent.putExtra("password",password)

        activity.startService(serviceIntent)

    }



    init {


        mView.initView()

    }


    override fun StampajHello() {
        mView.setName("Hello Zileee")
    }
    override fun onClick(activity: Activity)
    {
        Toast.makeText(activity, "Its toast!", Toast.LENGTH_SHORT).show()
    }









}