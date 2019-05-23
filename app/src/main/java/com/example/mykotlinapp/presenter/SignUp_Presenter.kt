package com.example.mykotlinapp.presenter

import android.app.Activity
import android.content.Intent
import android.support.v4.app.FragmentActivity
import android.widget.Toast
import com.example.mykotlinapp.R
import com.example.mykotlinapp.contract.MainActivityContract
import com.example.mykotlinapp.services.Login_Service
import com.example.mykotlinapp.services.SignUpService
import com.example.mykotlinapp.view.RandomFragment
import com.example.mykotlinapp.view.SignUpFragment


class SignUp_Presenter(private val mView: MainActivityContract.View_frag2) : MainActivityContract.SignUp_frag2 {


    override fun noviFragment(activity: Activity) {
        Toast.makeText(activity, "Pretisnuto", Toast.LENGTH_SHORT).show()
        var newFragment = RandomFragment()
        val fm = (activity as FragmentActivity).supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.replace(R.id.myContainer, newFragment)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }
    override fun SignUp(activity: Activity)
    {
        val username=mView.getTextFromUsername()
        val password=mView.getTextFromPassword()
        val ime= mView.getTextFromIme()
        val prezime=mView.getTextFromPrezime()

        //val Service = Intent("services.Login_Service")
        val serviceIntent = Intent(activity, SignUpService::class.java)
        serviceIntent.putExtra("username", username)
        serviceIntent.putExtra("password",password)
        serviceIntent.putExtra("ime",ime)
        serviceIntent.putExtra("prezime",prezime)

        activity.startService(serviceIntent)
        Toast.makeText(activity, "Pretisnuto", Toast.LENGTH_SHORT).show()

    }
    init {


        mView.initView()

    }



}
