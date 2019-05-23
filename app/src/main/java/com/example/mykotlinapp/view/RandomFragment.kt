package com.example.mykotlinapp.view

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mykotlinapp.R
import com.example.mykotlinapp.contract.MainActivityContract

class RandomFragment : Fragment()
{
    private lateinit var mPresenter: MainActivityContract.SignUp_frag2
    private lateinit var activity: Activity
    private lateinit var model: MainActivityContract.Model


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View
    {


        var retView  = inflater.inflate(R.layout.random_fragment, container, false)


        return retView
    }

}