package com.jb15613.themechooser.utility

import android.content.Context
import android.content.SharedPreferences

object FragmentSwapperUtilities {

    fun getCurrentNav(context: Context): String {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME_KEY, Context.MODE_PRIVATE)
        return prefs.getString(PREF_NAV_CURRENT, NAV_ITEM_HOME).toString()
    } // getCurrentNav

    fun setCurrentNav(context: Context, value: String) {
        val prefs: SharedPreferences = context.getSharedPreferences(PREFERENCE_NAME_KEY, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(PREF_NAV_CURRENT, value)
        editor.apply()
    } // setCurrentNav

}