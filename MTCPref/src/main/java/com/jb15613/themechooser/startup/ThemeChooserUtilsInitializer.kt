package com.jb15613.themechooser.startup

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.PREF_NAME_KEY
import com.jb15613.themechooser.utility.PrefUtils
import com.jb15613.themechooser.utility.ThemeChooserUtils

/**
## Startup Initializer for the [ThemeChooserUtils] Class
 */
class ThemeChooserUtilsInitializer : Initializer<ThemeChooserUtils> {

    override fun create(context: Context): ThemeChooserUtils {
        mResources = context.resources
        return ThemeChooserUtils
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        lateinit var mResources: Resources
    }

}