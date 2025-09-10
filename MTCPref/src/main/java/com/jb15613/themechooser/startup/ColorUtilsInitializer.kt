package com.jb15613.themechooser.startup

import android.content.Context
import android.content.res.Resources
import android.util.Log
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.ColorUtils

/**
## Startup Initializer for the [ColorUtils] Class
 */

internal lateinit var cuiResources: Resources
    private set // Make the setter private to this file

class ColorUtilsInitializer : Initializer<ColorUtils> {

    override fun create(context: Context): ColorUtils {
        Log.d("ColorUtilsInitializer", "Creating and initializing cuiResources.")
        cuiResources = context.resources
        return ColorUtils
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        fun getCuiResources(): Resources {
            if (!::cuiResources.isInitialized) {
                // This state should ideally not be reached if AppStartup is working correctly
                // and PrefUtils methods are called after app initialization.
                throw IllegalStateException("cuiResources has not been initialized. ColorUtilsInitializer.create() was not called or completed.")
            }
            return cuiResources
        }
    }

}