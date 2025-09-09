package com.jb15613.themechooser.startup

import android.content.Context
import android.content.res.Resources
import androidx.startup.Initializer
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
        return listOf(PrefUtilsInitializer::class.java)
    }

    companion object {
        lateinit var mResources: Resources
    }

}