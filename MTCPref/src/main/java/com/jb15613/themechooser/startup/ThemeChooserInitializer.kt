package com.jb15613.themechooser.startup

import android.content.Context
import android.content.SharedPreferences
import androidx.startup.Initializer
import com.jb15613.themechooser.mtcpref.ThemeChooser
import com.jb15613.themechooser.utility.PREF_NAME_KEY

class ThemeChooserInitializer : Initializer<ThemeChooser> {

    override fun create(context: Context): ThemeChooser {
        mPrefs = context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        return ThemeChooser
    }

    override fun dependencies(): List<Class<out Initializer<*>>> {
        return emptyList()
    }

    companion object {
        lateinit var mPrefs: SharedPreferences
    }

}