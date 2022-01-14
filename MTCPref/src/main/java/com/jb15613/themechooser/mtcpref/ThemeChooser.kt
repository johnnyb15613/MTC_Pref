package com.jb15613.themechooser.mtcpref

import android.content.Context
import android.content.SharedPreferences
import com.jb15613.themechooser.utility.*


object ThemeChooser {

    /**
     * getTheme(context: [Context]): [Int]
     *
     * This method will return a Theme from SharedPreferences using LIGHTBLUE as the default
     *
     * @param context a [Context] used to retrieve [SharedPreferences]
     *
     * @return [Int] the Resource Id of the Theme
     */
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

    /**
     * getTheme(themeName: [String]): [Int]
     *
     * This method will return a Theme from the given ThemeName
     *
     * @param themeName a [String] that is the Theme Name
     *
     * @return [Int] the Resource Id of the Theme
     */
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