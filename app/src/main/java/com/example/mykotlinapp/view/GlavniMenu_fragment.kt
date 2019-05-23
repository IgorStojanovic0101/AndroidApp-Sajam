package com.example.mykotlinapp.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mykotlinapp.R
import com.example.mykotlinapp.contract.MainActivityContract
import com.example.mykotlinapp.presenter.GlavniMenuPresenterFrag
import com.example.mykotlinapp.presenter.GlavniMenu_fragmentPresenter
import kotlinx.android.synthetic.main.glavni_menu_fragment.*
import kotlinx.android.synthetic.main.glavni_menu_fragment.view.*


class GlavniMenu_fragment :Fragment(),MainActivityContract.GlavniView_fragmentView
{

    private lateinit var mPresenter: MainActivityContract.GlavniMenu_fragmentPresenter
    private lateinit var per:String
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val activity = this.activity!!




         val args =arguments
            per = args!!.get("username") as String


        mPresenter= GlavniMenuPresenterFrag(this)
            //   model= Utils.gsonParser()!!.fromJson(personJsonString, MainActivityModel::class.java)



        }

    override fun initView() {
        hello.text = per
    }

        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {


        var retView  = inflater.inflate(R.layout.glavni_menu_fragment, container, false)

        return retView
    }
}