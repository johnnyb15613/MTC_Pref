package com.jb15613.themechooser.mtcpref

import android.content.SharedPreferences
import com.jb15613.themechooser.startup.ThemeChooserInitializer
import com.jb15613.themechooser.utility.*


object ThemeChooser {

    var mPrefs: SharedPreferences

    var isInitialized = false

    init {
        isInitialized = true
        mPrefs = ThemeChooserInitializer.mPrefs
    }

    /**
     * getTheme(): [Int]
     *
     * This method will return a Theme from SharedPreferences using LIGHTBLUE as the default
     *
     * @return [Int] the Resource Id of the Theme
     */
    fun getTheme(): Int {
        val themeName = mPrefs.getString(PREF_THEME_KEY, LIGHTBLUE).toString()
        val isLightTheme = mPrefs.getBoolean(PREF_THEME_HUE_KEY, false)

        ColorPrefUtils.setThemeColorsToPrefs(themeName, "ThemeChooser.getTheme()Int")

        return if (!isLightTheme) {
            // Dark Theme
            if (themeName.contains(THEME_SPLITTER)) {
                // Custom Color Theme
                DarkThemeUtils.getCustomColoredDarkTheme(themeName)
            } else {
                // Default Color Theme
                ThemeUtils.getColoredThemeDark(themeName)
            } // if theme contains "-"
        } else {
            // Light Theme
            if (themeName.contains(THEME_SPLITTER)) {
                // Custom Color Theme
                LightThemeUtils.getCustomColoredLightTheme(themeName)
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
        ColorPrefUtils.setThemeColorsToPrefs(themeName, "ThemeChooser.getTheme(themeName: String)Int")
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
                DarkThemeUtils.getCustomColoredDarkTheme(tN)
            } else {
                // Default Color Theme
                ThemeUtils.getColoredThemeDark(tN)
            } // if theme contains "-"
        } else {
            // Light Theme
            if (tN.contains(THEME_SPLITTER)) {
                // Custom Color Theme
                LightThemeUtils.getCustomColoredLightTheme(tN)
            } else {
                // Default Color Theme
                ThemeUtils.getColoredThemeLight(tN)
            } // if theme contains "-"
        } // if theme is dark or light
    } // getTheme
}