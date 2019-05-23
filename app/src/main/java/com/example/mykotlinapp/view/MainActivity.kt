package com.example.mykotlinapp.view

import android.app.Activity
import android.content.ContentValues
import android.support.v4.app.Fragment
import android.content.Context
import android.os.Bundle
import com.example.mykotlinapp.R

import com.example.mykotlinapp.presenter.MainActivityPresenter

import com.example.mykotlinapp.contract.MainActivityContract
import kotlinx.android.synthetic.main.content_main.*
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.widget.Toast
import com.example.mykotlinapp.Utils

import com.example.mykotlinapp.contract.OnHeadlineSelectedListener




class MainActivity : AppCompatActivity(), OnHeadlineSelectedListener {

   // private lateinit var onDataPass:OnDataPass
    private lateinit var mPresenter: MainActivityContract.Presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)

        mPresenter = MainActivityPresenter()
       // val bundle=Bundle()
      // val data= Utils.gsonParser()?.toJson(mPresenter.model)
        //bundle.putString("data_key",data)



       // onDataPass.Pass("Hello");
        val transaction = supportFragmentManager.beginTransaction()

        var newFragment = UlazniFragment() as android.support.v4.app.Fragment
      //  newFragment.arguments=bundle


        transaction.replace(R.id.myContainer,newFragment)
        transaction.commit()

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onArticleSelected(username: String,ime:String,prezime:String) {


        mPresenter.UlazUmenuActivity(this,username,ime,prezime)
    }

    override fun onAttachFragment(fragment:  android.support.v4.app.Fragment?) {

        if (fragment is UlazniFragment) {
            val headlinesFragment : UlazniFragment = fragment
            headlinesFragment.setOnHeadlineSelectedListener(this)
        }
    }






}

