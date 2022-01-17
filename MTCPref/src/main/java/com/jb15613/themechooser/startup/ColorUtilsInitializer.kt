package com.jb15613.themechooser.startup

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.util.Log
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.ColorUtils
import com.jb15613.themechooser.utility.PREF_NAME_KEY
import com.jb15613.themechooser.utility.PrefUtils

class ColorUtilsInitializer : Initializer<ColorUtils> {

    override fun create(context: Context): ColorUtils {
        Log.e(TAG, "create()")
        mResources = context.resources
        return ColorUtils
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        // return listOf(ColorPrefUtilsInitializer::class.java)
        return emptyList()
    }

    companion object {
        private const val TAG = "ColorUtilsInitializer"
        lateinit var mResources: Resources
    }

}