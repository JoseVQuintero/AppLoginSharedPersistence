package com.danisable.apploginsharedpersistence.utils

import android.content.Context
import android.content.SharedPreferences
import com.danisable.apploginsharedpersistence.utils.Constants.PREF_USER

object Utils {
    fun setPreferencesAppData(context: Context, key: String, value: String){
        val sharedPreferences: SharedPreferences = context.getSharedPreferences(PREF_USER, 0)
        val editor = sharedPreferences.edit()
        editor.putString(key,value)
        editor.apply()
    }

    fun getPreferencesAppData(context: Context, key: String): String? {
        val sharePreferences: SharedPreferences = context.getSharedPreferences(PREF_USER,0)
        return sharePreferences.getString(key, PREF_USER)
    }
}