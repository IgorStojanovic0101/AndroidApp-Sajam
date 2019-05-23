package com.example.mykotlinapp.presenter



import android.app.Activity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import com.example.mykotlinapp.R
import com.example.mykotlinapp.contract.MainActivityContract
import com.example.mykotlinapp.view.GlavniMenu_fragment

class GlavniMenuPresenterFrag(mView:MainActivityContract.GlavniView_fragmentView):MainActivityContract.GlavniMenu_fragmentPresenter {
    override fun StampajHello() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    init {
        mView.initView()
    }



}