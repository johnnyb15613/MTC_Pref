package com.jb15613.themechooser.startup

import android.content.Context
import android.content.res.Resources
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.ColorUtils

/**
## Startup Initializer for the [ColorUtils] Class
 */
class ColorUtilsInitializer : Initializer<ColorUtils> {

    override fun create(context: Context): ColorUtils {
        mResources = context.resources
        return ColorUtils
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        lateinit var mResources: Resources
    }

}