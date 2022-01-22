package com.jb15613.themechooser.startup

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.PREF_NAME_KEY
import com.jb15613.themechooser.utility.PrefUtils

/**
## Startup Initializer for the [PrefUtils] Class
 */
class PrefUtilsInitializer : Initializer<PrefUtils> {

    override fun create(context: Context): PrefUtils {
        mPrefs = context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        mResources = context.resources
        return PrefUtils
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        lateinit var mPrefs: SharedPreferences
        lateinit var mResources: Resources
    }

}