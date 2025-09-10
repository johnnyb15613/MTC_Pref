package com.jb15613.themechooser.startup

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.util.Log
import androidx.startup.Initializer
import com.jb15613.themechooser.utility.PREF_NAME_KEY
import com.jb15613.themechooser.utility.PrefUtils

/**
## Startup Initializer for the [PrefUtils] Class
 */
internal lateinit var puiPrefs: SharedPreferences
    private set // Make the setter private to this file

internal lateinit var puiResources: Resources
    private set // Make the setter private to this file

class PrefUtilsInitializer : Initializer<PrefUtils> { // Return SharedPreferences or a marker type

    override fun create(context: Context): PrefUtils {
        Log.d("PrefUtilsInitializer", "Creating and initializing puiPrefs and puiResources.")
        puiPrefs = context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE) // Use a proper name
        puiResources = context.resources
        return PrefUtils
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        fun getPuiPrefs(): SharedPreferences {
            if (!::puiPrefs.isInitialized) {
                // This state should ideally not be reached if AppStartup is working correctly
                // and PrefUtils methods are called after app initialization.
                throw IllegalStateException("puiPrefs has not been initialized. PrefUtilsInitializer.create() was not called or completed.")
            }
            return puiPrefs
        }

        fun getPuiResources(): Resources {
            if (!::puiResources.isInitialized) {
                // This state should ideally not be reached if AppStartup is working correctly
                // and PrefUtils methods are called after app initialization.
                throw IllegalStateException("puiResources has not been initialized. PrefUtilsInitializer.create() was not called or completed.")
            }
            return puiResources
        }

        // Optional: A more direct way to check initialization from outside, if needed
        val isPrefsInitialized: Boolean
            get() = ::puiPrefs.isInitialized
    } // Companion Object
} // Class
