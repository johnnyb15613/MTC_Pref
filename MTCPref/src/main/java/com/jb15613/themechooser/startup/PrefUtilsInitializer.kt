package com.jb15613.themechooser.startup

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.PREF_NAME_KEY
import com.jb15613.themechooser.utility.PrefUtils

class PrefUtilsInitializer : Initializer<PrefUtils> {

    override fun create(context: Context): PrefUtils {
        Log.e(TAG, "create()")
        mPrefs = context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        return PrefUtils
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        // return listOf(ColorUtilsInitializer::class.java)
        return emptyList()
    }

    companion object {
        private const val TAG = "PrefUtilsInitializer"
        lateinit var mPrefs: SharedPreferences
    }

}