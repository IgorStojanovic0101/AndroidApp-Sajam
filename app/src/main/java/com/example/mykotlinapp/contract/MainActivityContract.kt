package com.example.mykotlinapp.contract
import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.View
import com.example.mykotlinapp.R
import kotlinx.android.synthetic.main.content_main.view.*
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
interface MainActivityContract {


    interface UlazniView
    {
        fun initView()
        fun setViewData(data: String)
        fun setName(data: String)
        fun getTextFromUsername():String
        fun getTextFromPassword():String
        fun setPassword(data:String)
    }
    interface View_frag2
    {
        fun initView()
        fun getTextFromUsername():String
        fun getTextFromPassword():String
        fun getTextFromIme():String
        fun getTextFromPrezime():String

    }
    interface GlavniView
    {
        fun initView()

    }
    interface GlavniView_fragmentView
    {
        fun initView()
    }

    interface Model {

        var data: String
        var ime:String

        var prezime:String
        var username:String
    }

    interface Presenter
    {
        var model:Model
        fun UlazUmenuActivity(activity: Activity,username:String,ime:String,prezime:String)

    }
    interface GlavniPresenter
    {
        fun glavniFragment(activity:Activity,bundle: String)
        fun PozoviAutomobile()
    }

    interface UlazniPresenter
    {
        fun noviFragment(activity: Activity)
        fun StampajHello()
        fun onClick(activity: Activity)

        fun Login(activity: Activity)
    }
    interface GlavniMenu_fragmentPresenter
    {
        fun StampajHello()
    }
    interface SignUp_frag2 {
        fun noviFragment(activity: Activity)
        fun SignUp(activity: Activity)

    }

}
