package com.jb15613.themechooser.mtcpref

import android.content.SharedPreferences
import android.util.Log
import com.jb15613.themechooser.utility.*

/**
 * ## Used to set the *ThemeColor* without the [Theme.ThemeBuilder]
 */
object ThemeChooser {

    private var isDebug: Boolean = false
    private var isUnitTest: Boolean = false

    private var mTag = "ThemeChooser.getTheme()"

    /**
     * ## This method will return a Theme ID
     *
     * If no argument is passed, it will get value from [SharedPreferences] using [LIGHTBLUE] as default
     *
     * If argument is passed, it will use the supplied [String]
     *
     * @param themeString a (optional) [String] that represents a Theme Name
     *
     * @return [Int] the Resource Id of the Theme
     */
    fun getTheme(vararg themeString: String): Int {

        isDebug = DebugUtils.isDebugMode
        isUnitTest = TestUtils.isRunningUnitTest()

        val passedThemeName: String
        val arraySize = themeString.size

        if (isDebug && !isUnitTest) Log.e(mTag, "vararg size : $arraySize")

        passedThemeName = if (arraySize == 0) {
            PrefUtils.getThemeName()
        } else {
            themeString[0]
        }

        if (isDebug && !isUnitTest) Log.e(mTag, "passedThemeName : $passedThemeName") // Light Blue

        val mAccentName: String
        var mThemeHue = false

        if (passedThemeName.contains(HUE_SPLITTER)) {
            // This means that a hue was given

            val items: Array<String> = passedThemeName.split(HUE_SPLITTER).toTypedArray()
            val name = items[0].trim()
            val hue = items[1].trim()

            if (hue == HUE_LIGHT) mThemeHue = true
            if (hue == HUE_DARK) mThemeHue = false

            mAccentName = if (name.contains(THEME_SPLITTER)) {

                val itemss: List<String> = name.split(THEME_SPLITTER)
                itemss[1].trim()

            } else {
                ""
            } // if contains theme splitter

        } else {
            // This means that no hue was given
            // It will default to dark
            mThemeHue = false
            mAccentName = if (passedThemeName.contains(THEME_SPLITTER)) {
                val items: List<String> = passedThemeName.split(THEME_SPLITTER)
                items[1].trim()
            } else {
                ""
            } // if contains theme splitter

        } // if contains hue splitter

        val themeId: Int

        if (mThemeHue) {
            // Light Theme
            if (mAccentName == "") {
                // Light Normal Accent Color
                val customName: String = if (passedThemeName.contains(HUE_LIGHT)) {
                    if (!isUnitTest) PrefUtils.setThemeName(passedThemeName)
                    val hSplit: List<String> = passedThemeName.split(HUE_SPLITTER)
                    hSplit[0]
                } else {
                    if (!isUnitTest) PrefUtils.setThemeName("$passedThemeName$HUE_SPLITTER$HUE_LIGHT")
                    passedThemeName
                }
                themeId = ThemeUtils.getColoredThemeLight(customName)
            } else {
                // Light Custom Accent Color
                val customName: String = if (passedThemeName.contains(HUE_LIGHT)) {
                    if (!isUnitTest) PrefUtils.setThemeName(passedThemeName)
                    val hSplit: List<String> = passedThemeName.split(HUE_SPLITTER)
                    hSplit[0]
                } else {
                    if (!isUnitTest) PrefUtils.setThemeName("$passedThemeName$HUE_SPLITTER$HUE_LIGHT")
                    passedThemeName
                }
                themeId = LightThemeUtils.getCustomColoredLightTheme(customName)
            }
        } else {
            // Dark Theme
            if (mAccentName == "") {
                // Dark Normal Accent Color
                val customName: String = if (passedThemeName.contains(HUE_DARK)) {
                    if (!isUnitTest) PrefUtils.setThemeName(passedThemeName)
                    val hSplit: List<String> = passedThemeName.split(HUE_SPLITTER)
                    hSplit[0]
                } else {
                    if (!isUnitTest) PrefUtils.setThemeName("$passedThemeName$HUE_SPLITTER$HUE_DARK")
                    passedThemeName
                }
                themeId = ThemeUtils.getColoredThemeDark(customName)
            } else {
                // Dark Custom Accent Color
                val customName: String = if (passedThemeName.contains(HUE_DARK)) {
                    if (!isUnitTest) PrefUtils.setThemeName(passedThemeName)
                    val hSplit: List<String> = passedThemeName.split(HUE_SPLITTER)
                    hSplit[0]
                } else {
                    if (!isUnitTest) PrefUtils.setThemeName("$passedThemeName$HUE_SPLITTER$HUE_DARK")
                    passedThemeName
                }
                themeId = DarkThemeUtils.getCustomColoredDarkTheme(customName)
            }
        }

        return themeId

    } // getTheme
}