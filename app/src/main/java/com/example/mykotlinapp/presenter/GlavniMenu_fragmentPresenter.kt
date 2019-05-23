package com.example.mykotlinapp.presenter

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.example.mykotlinapp.R
import com.example.mykotlinapp.contract.MainActivityContract
import com.example.mykotlinapp.view.GlavniMenu_fragment

class GlavniMenu_fragmentPresenter(mView:MainActivityContract.GlavniView):MainActivityContract.GlavniPresenter {


    init {
        mView.initView()
    }

    override fun glavniFragment(activity: Activity,username:String) {
        val fragment_manager = (activity as FragmentActivity).supportFragmentManager
        val fragmentTransaction = fragment_manager.beginTransaction()
        var newFragment = GlavniMenu_fragment()
         val bundle= Bundle()

        bundle.putString("username",username)

        newFragment.arguments=bundle


        fragmentTransaction.replace(R.id.glavni_activity,newFragment)
        fragmentTransaction.commit()
    }
    override fun PozoviAutomobile(){



    }

}