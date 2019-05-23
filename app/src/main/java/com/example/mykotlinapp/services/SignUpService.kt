package com.example.mykotlinapp.services



import android.app.Service
import android.content.ContentValues
import android.content.Intent
import android.os.IBinder
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.Volley
import com.example.mykotlinapp.contract.MainActivityContract
import com.android.volley.VolleyError
import org.json.JSONException

import org.json.JSONObject
import org.json.JSONArray
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest

import android.os.AsyncTask
import android.util.Log
import android.widget.Toast.LENGTH_LONG
import com.android.volley.toolbox.JsonArrayRequest
import com.example.mykotlinapp.asinhroni.SignUpTask
import com.example.mykotlinapp.automobili.MySignUpParams
import com.google.gson.JsonObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class SignUpService : Service() {
    private lateinit var myFilterResponse: Intent
    private lateinit var mQueue: RequestQueue
    private lateinit var String_za_slanje: String

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        //Log.e("MyService3-onStart","I am alive");
        //Dug zadataka ide u poseban thread

        myFilterResponse = Intent("SignUp_rec")
        val username=intent.getStringExtra("username")
        val password=intent.getStringExtra("password")
        val ime=intent.getStringExtra("ime")
        val prezime=intent.getStringExtra("prezime")
        var mp= MySignUpParams(ime,prezime,username,password,this,myFilterResponse)


                SignUpTask().execute(mp)



        stopSelf()
        return Service.START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }






}