package com.jb15613.themechooser.startup

import android.content.Context
import android.content.res.Resources
import android.util.Log
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.color.AccentColor

/**
 ## Startup Initializer for the [AccentColor] Class
 */

internal lateinit var acResources: Resources
    private set // Make the setter private to this file

class AccentColorInitializer : Initializer<AccentColor> {

    override fun create(context: Context): AccentColor {
        Log.d("AccentColorInitializer", "Creating and initializing acResources.")
        acResources = context.resources
        return AccentColor
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        fun getAcResources(): Resources {
            if (!::acResources.isInitialized) {
                // This state should ideally not be reached if AppStartup is working correctly
                // and PrefUtils methods are called after app initialization.
                throw IllegalStateException("acResources has not been initialized. AccentColorInitializer.create() was not called or completed.")
            }
            return cuiResources
        }
    }

}