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
internal lateinit var mPrefs: SharedPreferences
    private set // Make the setter private to this file

internal lateinit var mResources: Resources
    private set // Make the setter private to this file

class PrefUtilsInitializer : Initializer<PrefUtils> { // Return SharedPreferences or a marker type

    override fun create(context: Context): PrefUtils {
        Log.d("PrefUtilsInitializer", "Creating and initializing mPrefs.")
        mPrefs = context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE) // Use a proper name
        mResources = context.resources
        return PrefUtils
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        fun getMPrefs(): SharedPreferences {
            if (!::mPrefs.isInitialized) {
                // This state should ideally not be reached if AppStartup is working correctly
                // and PrefUtils methods are called after app initialization.
                throw IllegalStateException("mPrefs has not been initialized. PrefUtilsInitializer.create() was not called or completed.")
            }
            return mPrefs
        }

        fun getMResources(): Resources {
            if (!::mResources.isInitialized) {
                // This state should ideally not be reached if AppStartup is working correctly
                // and PrefUtils methods are called after app initialization.
                throw IllegalStateException("mResources has not been initialized. PrefUtilsInitializer.create() was not called or completed.")
            }
            return mResources
        }

        // Optional: A more direct way to check initialization from outside, if needed
        val isPrefsInitialized: Boolean
            get() = ::mPrefs.isInitialized
    } // Companion Object
} // Class
