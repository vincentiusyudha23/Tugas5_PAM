package com.example.pam

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.fragment.app.FragmentActivity

class SessionManager(context: Context) {
    val sharedPreferences : SharedPreferences
    var editor : SharedPreferences.Editor? = null
    val keyPreference = "SMILEDB"
    val login = "login"
    val keyUserName = "Username"
    val keyPassword = "Password"


    init{
        sharedPreferences = context.getSharedPreferences(keyPreference, Context.MODE_PRIVATE)
        editor = sharedPreferences?.edit()
    }

    fun setDetails(userName: String, password: String){
        editor?.putString(keyUserName, userName)
        editor?.putString(keyPassword, password)
        editor?.apply()
    }

    fun setStatusLogin(status: Boolean){
        sharedPreferences.edit().putBoolean(login, status).apply()
    }

    fun getStatusLogin(): Boolean{
        return sharedPreferences.getBoolean(login, false)
    }

    fun getRememberUser(): ArrayList<String>{
        var userList = arrayListOf<String>()
        userList.add(sharedPreferences.getString(keyUserName,"null")!!)
        userList.add(sharedPreferences.getString(keyPassword,"null")!!)
        return userList
    }
}