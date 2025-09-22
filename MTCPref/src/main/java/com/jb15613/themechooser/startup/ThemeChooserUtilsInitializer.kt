package com.jb15613.themechooser.startup

import android.content.Context
import android.content.res.Resources
import android.util.Log
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.ThemeChooserUtils

/**
## Startup Initializer for the [ThemeChooserUtils] Class
 */

internal lateinit var tcuiResources: Resources
    private set // Make the setter private to this file

class ThemeChooserUtilsInitializer : Initializer<ThemeChooserUtils> {

    override fun create(context: Context): ThemeChooserUtils {
        Log.d("ThemeChooserUtilsInitializer", "Creating and initializing tcuiResources.")
        tcuiResources = context.resources
        return ThemeChooserUtils
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        fun getTcuiResources(): Resources {
            if (!::tcuiResources.isInitialized) {
                // This state should ideally not be reached if AppStartup is working correctly
                // and PrefUtils methods are called after app initialization.
                throw IllegalStateException("tcuiResources has not been initialized. ThemeChooserUtilsInitializer.create() was not called or completed.")
            }
            return tcuiResources
        }
    }

}