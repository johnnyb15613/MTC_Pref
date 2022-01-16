package com.jb15613.themechooser.startup

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.util.Log
import androidx.startup.Initializer
import com.jb15613.themechooser.mtcpref.ThemeChooser
import com.jb15613.themechooser.utility.PREF_NAME_KEY

class ThemeChooserInitializer : Initializer<ThemeChooser> {

    override fun create(context: Context): ThemeChooser {
        Log.e(TAG, "create()")
        mPrefs = context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        mResources = context.resources
        return ThemeChooser
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        private const val TAG = "ThemeChooserInitializer"
        lateinit var mPrefs: SharedPreferences
        lateinit var mResources: Resources
    }

}