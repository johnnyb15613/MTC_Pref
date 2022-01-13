package com.jb15613.themechooser.mtcpref

import android.content.Context
import android.content.SharedPreferences
import com.jb15613.themechooser.utility.*


object ThemeChooser {
    fun getTheme(context: Context): Int {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        val themeName = prefs.getString(PREF_THEME_KEY, LIGHTBLUE)
        val isLightTheme = prefs.getBoolean(PREF_THEME_HUE_KEY, false)
        return if (!isLightTheme) {
            // Dark Theme
            if (themeName!!.contains(THEME_SPLITTER)) {
                // Custom Color Theme
                DarkThemeUtils().getCustomColoredDarkTheme(themeName)
            } else {
                // Default Color Theme
                ThemeUtils.getColoredThemeDark(themeName)
            } // if theme contains "-"
        } else {
            // Light Theme
            if (themeName!!.contains(THEME_SPLITTER)) {
                // Custom Color Theme
                LightThemeUtils().getCustomColoredLightTheme(themeName)
            } else {
                // Default Color Theme
                ThemeUtils.getColoredThemeLight(themeName)
            } // if theme contains "-"
        } // if theme is dark or light
    } // getTheme

    fun getTheme(themeName: String): Int {
        var tN = themeName
        var isLightTheme = true
        if (themeName.contains(HUE_SPLITTER)) {
            // dark/light specified
            // figure out which one to use
            val tn: Array<String> = themeName.split(HUE_SPLITTER).toTypedArray()
            tN = tn[0]
            when (tn[1].trim { it <= ' ' }) {
                "Dark" -> isLightTheme = false
                "Light" -> isLightTheme = true
            }
        }
        return if (!isLightTheme) {
            // Dark Theme
            if (tN.contains(THEME_SPLITTER)) {
                // Custom Color Theme
                DarkThemeUtils().getCustomColoredDarkTheme(tN)
            } else {
                // Default Color Theme
                ThemeUtils.getColoredThemeDark(tN)
            } // if theme contains "-"
        } else {
            // Light Theme
            if (tN.contains(THEME_SPLITTER)) {
                // Custom Color Theme
                LightThemeUtils().getCustomColoredLightTheme(tN)
            } else {
                // Default Color Theme
                ThemeUtils.getColoredThemeLight(tN)
            } // if theme contains "-"
        } // if theme is dark or light
    } // getTheme
}