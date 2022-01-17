package com.jb15613.themechooser.startup

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.util.Log
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.ColorPrefUtils
import com.jb15613.themechooser.utility.PREF_NAME_KEY

class ColorPrefUtilsInitializer : Initializer<ColorPrefUtils> {

    override fun create(context: Context): ColorPrefUtils {
        Log.e(TAG, "create()")
        mResources = context.resources
        return ColorPrefUtils
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        private const val TAG = "ColorPrefUtilsInit"
        lateinit var mResources: Resources
    }

}