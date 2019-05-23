package com.example.mykotlinapp

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object Utils {
    private var gson: Gson? = null

    fun gsonParser(): Gson? {
            if (null == gson) {
                val builder = GsonBuilder()
                gson = builder.create()
            }
            return gson
        }
}