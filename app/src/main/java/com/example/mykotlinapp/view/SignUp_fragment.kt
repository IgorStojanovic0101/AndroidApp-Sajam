package com.example.mykotlinapp.view

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.mykotlinapp.R
import com.example.mykotlinapp.contract.MainActivityContract

import com.example.mykotlinapp.presenter.SignUp_Presenter
import kotlinx.android.synthetic.main.main.*
import kotlinx.android.synthetic.main.sign_up_fragment.*
import org.json.JSONObject


class SignUpFragment : Fragment(),MainActivityContract.View_frag2{

    private lateinit var mPresenter: MainActivityContract.SignUp_frag2
    private lateinit var activity: Activity
    private lateinit var model:MainActivityContract.Model
    private lateinit var  broadcastReceiver: BroadcastReceiver


    override fun initView() {
        custom.setOnClickListener {
            Toast.makeText(activity, "Pretisnuto", Toast.LENGTH_SHORT).show()
            mPresenter.noviFragment(activity)
        }
      
        signUpAllData.setOnClickListener {
            mPresenter.SignUp(activity)
            registerReceiver()
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity = this.getActivity()!!

        mPresenter = SignUp_Presenter(this)
//Springggg----------------------------------------

    }
    override fun getTextFromUsername(): String {
        return username_za_signup.text.toString()
    }
    override fun getTextFromPassword():String
    {
        return password_za_signup.text.toString()
    }
    override fun getTextFromIme():String
    {
        return ime.text.toString()
    }
    override fun getTextFromPrezime():String
    {
        return prezime.text.toString()
    }
    private fun registerReceiver() {
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val otpCode = intent.getStringExtra("serviceDataSignUp")
                val JO =  otpCode.toString()
                Toast.makeText(activity,JO,Toast.LENGTH_SHORT).show()



//                model.username=username
                //    val data= Utils.gsonParser()?.toJson(model)
                //    val bundle=Bundle()
                //    bundle.putString("data_key",data)
                //mPresenter.UlazUmenuActivity(activity,username,ime,prezime)




            }
        }
        activity.registerReceiver(broadcastReceiver, IntentFilter("SignUp_rec"))
    }





        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {


        var retView  = inflater.inflate(R.layout.sign_up_fragment, container, false)


        return retView
    }

}