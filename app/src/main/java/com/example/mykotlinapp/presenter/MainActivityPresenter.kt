package com.example.mykotlinapp.presenter

import android.app.Activity
import android.content.Intent
import com.example.mykotlinapp.view.GlavniActivity

import com.example.mykotlinapp.contract.MainActivityContract
import com.example.mykotlinapp.contract.MainActivityContract.Model
import com.example.mykotlinapp.model.MainActivityModel


class MainActivityPresenter : MainActivityContract.Presenter {
    override fun UlazUmenuActivity(activity: Activity, username: String, ime: String, prezime: String) {
        val intent = Intent(activity, GlavniActivity::class.java)
        intent.putExtra("username",username)
        intent.putExtra("ime",ime)
        intent.putExtra("prezime",prezime)

        activity.startActivity(intent)
    }

    override lateinit var model: Model



    init {

        model =MainActivityModel()

    }


}
