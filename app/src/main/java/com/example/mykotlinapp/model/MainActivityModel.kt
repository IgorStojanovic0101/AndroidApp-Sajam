package com.example.mykotlinapp.model


import com.example.mykotlinapp.contract.MainActivityContract
import com.example.mykotlinapp.contract.MainActivityContract.Presenter



class MainActivityModel : MainActivityContract.Model {
    override var prezime: String
        get() = prezime
        set(value) {
            prezime=value
        }
    override var username: String
        get() =username
        set(value) {
            username=value
        }
    override var ime: String
        get() = ime
        set(value) {
            ime=value
        }

    override var data: String
        get() = "blaaa"
        set(value) {
            data=value
        }

}