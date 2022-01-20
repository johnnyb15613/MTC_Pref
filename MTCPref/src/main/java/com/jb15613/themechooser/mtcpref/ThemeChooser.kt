package com.jb15613.themechooser.mtcpref

import android.content.SharedPreferences
import android.util.Log
import com.jb15613.themechooser.startup.ThemeChooserInitializer
import com.jb15613.themechooser.utility.*


object ThemeChooser {

    var isDebug: Boolean = false

    var mPrefs: SharedPreferences

    var isInitialized = false

    var mTag = "ThemeChooser.getTheme()"

    init {
        isInitialized = true
        mPrefs = ThemeChooserInitializer.mPrefs
    }

    /**
     * getTheme(vararg themeString: String): [Int]
     *
     * This method will return a Theme ID
     * If no argument is passed, it will get value from [SharedPreferences] using [LIGHTBLUE] as default
     * If argument is passed, it will use the supplied [String]
     *
     * @param themeString a (optional) [String] that represents a Theme Name
     *
     * @return [Int] the Resource Id of the Theme
     */
    fun getTheme(vararg themeString: String): Int {

        isDebug = DebugUtils.isDebugMode

        val passedThemeName: String
        val arraySize = themeString.size

        if (isDebug) Log.e(mTag, "vararg size : $arraySize")

        passedThemeName = if (arraySize == 0) {
            mPrefs.getString(PREF_THEME_NAME_KEY, LIGHTBLUE).toString()
        } else {
            themeString[0]
        }

        if (isDebug) Log.e(mTag, "passedThemeName : $passedThemeName") // Light Blue

        val mThemeName: String
        val mAccentName: String
        var mThemeHue = false

        if (passedThemeName.contains(HUE_SPLITTER)) {
            // This means that a hue was given
            // Light Blue - Dark || Light Blue - Light
            // Light Blue & Red A1 - Dark

            val items: Array<String> = passedThemeName.split(HUE_SPLITTER).toTypedArray()
            val name = items[0].trim()
            val hue = items[1].trim()

            if (hue == "Light") mThemeHue = true
            if (hue == "Dark") mThemeHue = false

            if (name.contains(THEME_SPLITTER)) {

                val itemss: List<String> = name.split(THEME_SPLITTER)
                mThemeName = itemss[0].trim()
                mAccentName = itemss[1].trim()

            } else {
                mThemeName = name
                mAccentName = ""
            } // if contains theme splitter

        } else {
            // This means that no hue was given
            // It will default to dark
            // Light Blue
            // Light Blue & Red A1
            mThemeHue = false
            if (passedThemeName.contains(THEME_SPLITTER)) {
                // This means that a theme splitter is present
                // Light Blue & Red A1
                val items: List<String> = passedThemeName.split(THEME_SPLITTER)
                mThemeName = items[0].trim()
                mAccentName = items[1].trim()
            } else {
                // This means that no theme splitter is present
                // Light Blue
                mThemeName = passedThemeName
                mAccentName = ""
            } // if contains theme splitter

        } // if contains hue splitter

        var themeId: Int = 0

        if (mThemeHue) {
            // Light Theme
            if (mAccentName == "") {
                // Light Normal Accent Color
                // Light Blue || Red || Amber
                val customName: String
                if (passedThemeName.contains("Light")) {
                    PrefUtils.setThemeName(passedThemeName)
                    val hSplit: List<String> = passedThemeName.split(HUE_SPLITTER)
                    customName = hSplit[0]
                } else {
                    PrefUtils.setThemeName("$passedThemeName - Light")
                    customName = passedThemeName
                }
                themeId = ThemeUtils.getColoredThemeLight(customName)
            } else {
                // Light Custom Accent Color
                // Light Blue & Orange A1
                val customName: String
                if (passedThemeName.contains("Light")) {
                    PrefUtils.setThemeName(passedThemeName)
                    val hSplit: List<String> = passedThemeName.split(HUE_SPLITTER)
                    customName = hSplit[0]
                } else {
                    PrefUtils.setThemeName("$passedThemeName - Light")
                    customName = passedThemeName
                }
                themeId = LightThemeUtils.getCustomColoredLightTheme(customName)
            }
        } else {
            // Dark Theme
            if (mAccentName == "") {
                // Dark Normal Accent Color
                // Light Blue || Red || Amber
                val customName: String
                if (passedThemeName.contains("Dark")) {
                    PrefUtils.setThemeName(passedThemeName)
                    val hSplit: List<String> = passedThemeName.split(HUE_SPLITTER)
                    customName = hSplit[0]
                } else {
                    PrefUtils.setThemeName("$passedThemeName - Dark")
                    customName = passedThemeName
                }
                themeId = ThemeUtils.getColoredThemeDark(customName)
            } else {
                // Dark Custom Accent Color
                // Light Blue & Orange A1
                val customName: String
                if (passedThemeName.contains("Dark")) {
                    PrefUtils.setThemeName(passedThemeName)
                    val hSplit: List<String> = passedThemeName.split(HUE_SPLITTER)
                    customName = hSplit[0]
                } else {
                    PrefUtils.setThemeName("$passedThemeName - Dark")
                    customName = passedThemeName
                }
                themeId = DarkThemeUtils.getCustomColoredDarkTheme(customName)
            }
        }

        return themeId

    } // getTheme
}