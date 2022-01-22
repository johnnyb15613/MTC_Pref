package com.jb15613.themechooser.startup

import android.content.Context
import android.content.res.Resources
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.color.AccentColor

/**
 ## Startup Initializer for the [AccentColor] Class
 */
class AccentColorInitializer : Initializer<AccentColor> {

    override fun create(context: Context): AccentColor {
        mResources = context.resources
        return AccentColor
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        lateinit var mResources: Resources
    }

}