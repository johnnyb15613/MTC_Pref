package com.jb15613.themechooser.utility

import android.content.Context
import android.graphics.Color
import android.util.Log

import android.util.TypedValue
import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.utility.PrefUtils.getThemeHue

/**
 * \object ThemeChooserUtils
 *
 * Class that holds all public endpoints for usage with the Library
 *
 */
object ThemeChooserUtils {

    /**
     * getThemeColor(): [Int]
     *
     * Retrieves color value of Primary Theme Color
     *
     * @return [Int] that is the color value for Primary Theme Color
     */
    fun getThemeColor(): Int {
        val color = PrefUtils.getThemeColorInt()
        // Log.e("getThemeColor.prefs", "$color")
        return color
    } // getThemeColor

    /**
     * getThemeColor(opacity: [Float]): [Int]
     *
     * Retrieves color value of Primary Theme Color with Opacity
     *
     * @param opacity a [Float] that is used to derive an opaque version of a solid color
     *
     * @return [Int] that is the color value for Primary Theme Color with desired opacity
     */
    fun getThemeColor(opacity: Float): Int {
        val themeColor = PrefUtils.getThemeColorInt()
        val color: Int = when (opacity.toDouble()) {
            1.0 -> themeColor
            0.9 -> themeColor and 0x00FFFFFF or -0x20000000
            0.8 -> themeColor and 0x00FFFFFF or -0x30000000
            0.7 -> themeColor and 0x00FFFFFF or -0x40000000
            0.6 -> themeColor and 0x00FFFFFF or -0x50000000
            0.5 -> themeColor and 0x00FFFFFF or -0x60000000
            0.4 -> themeColor and 0x00FFFFFF or -0x70000000
            0.3 -> themeColor and 0x00FFFFFF or -0x80000000
            0.2 -> themeColor and 0x00FFFFFF or 0x70000000
            0.1 -> themeColor and 0x00FFFFFF or 0x60000000
            else -> Color.TRANSPARENT
        }
        // Log.e("getThemeColorWO", "$color")
        return color
    } // getThemeColor

    /**
     * getThemeDarkColor(): [Int]
     *
     * Retrieves color value of Primary Theme Color Dark
     *
     * @return [Int] that is the color value for Primary Theme Color Dark
     */
    fun getThemeDarkColor(): Int {
        val color = PrefUtils.getThemeDarkColorInt()
        // Log.e("getThemeDarkColor", "$color")
        return color
    } // getThemeDarkColor

    /**
     * getThemeDarkColor(opacity: [Float]): [Int]
     *
     * Retrieves color value of Primary Theme Color Dark with Opacity
     *
     * @param opacity a [Float] that is used to derive an opaque version of a solid color\
     *
     * @return [Int] that is the color value for Primary Theme Color Dark with desired opacity
     */
    fun getThemeDarkColor(opacity: Float): Int {
        val themeDarkColor = PrefUtils.getThemeDarkColorInt()
        val color: Int = when (opacity.toDouble()) {
            1.0 -> themeDarkColor
            0.9 -> themeDarkColor and 0x00FFFFFF or -0x20000000
            0.8 -> themeDarkColor and 0x00FFFFFF or -0x30000000
            0.7 -> themeDarkColor and 0x00FFFFFF or -0x40000000
            0.6 -> themeDarkColor and 0x00FFFFFF or -0x50000000
            0.5 -> themeDarkColor and 0x00FFFFFF or -0x60000000
            0.4 -> themeDarkColor and 0x00FFFFFF or -0x70000000
            0.3 -> themeDarkColor and 0x00FFFFFF or -0x80000000
            0.2 -> themeDarkColor and 0x00FFFFFF or 0x70000000
            0.1 -> themeDarkColor and 0x00FFFFFF or 0x60000000
            else -> Color.TRANSPARENT
        }
        // Log.e("getDarkColorWO", "$color")
        return color
    } // getThemeDarkColor

    /**
     * getThemeAccentColor(): [Int]
     *
     * Retrieves color value of Accent Theme Color
     *
     * @return [Int] that is the color value for Accent Theme Color
     */
    fun getThemeAccentColor(): Int {
        val color = PrefUtils.getThemeAccentColorInt()
        // Log.e("getThemeAccentColor", "$color")
        return color
    } // getThemeAccentColor

    /**
     * getThemeAccentColor(opacity: [Float]): [Int]
     *
     * Retrieves color value of Accent Theme Color with Opacity
     *
     * @param opacity a [Float] that is used to derive an opaque version of a solid color
     *
     * @return [Int] that is the color value for Accent Theme Color with desired opacity
     */
    fun getThemeAccentColor(opacity: Float): Int {
        val themeAccentColor = PrefUtils.getThemeAccentColorInt()
        val color: Int = when (opacity.toDouble()) {
            1.0 -> themeAccentColor
            0.9 -> themeAccentColor and 0x00FFFFFF or -0x20000000
            0.8 -> themeAccentColor and 0x00FFFFFF or -0x30000000
            0.7 -> themeAccentColor and 0x00FFFFFF or -0x40000000
            0.6 -> themeAccentColor and 0x00FFFFFF or -0x50000000
            0.5 -> themeAccentColor and 0x00FFFFFF or -0x60000000
            0.4 -> themeAccentColor and 0x00FFFFFF or -0x70000000
            0.3 -> themeAccentColor and 0x00FFFFFF or -0x80000000
            0.2 -> themeAccentColor and 0x00FFFFFF or 0x70000000
            0.1 -> themeAccentColor and 0x00FFFFFF or 0x60000000
            else -> Color.TRANSPARENT
        }
        // Log.e("getAccentColorWO", "$color")
        return color
    } // getThemeAccentColor

    /**
     * getPrimaryBgColor(): [Int]
     *
     * Retrieves color value of Primary BG Color
     *
     * @return [Int] that is the color value for Primary BG Color
     */
    fun getPrimaryBgColor(): Int {
        val color = PrefUtils.getThemePrimaryBgColorInt()
        // Log.e("getPrimaryBgColor", "$color")
        return color
    } // getPrimaryBgColor

    /**
     * getSecondaryBgColor(): [Int]
     *
     * Retrieves color value of Secondary BG Color
     *
     * @return [Int] that is the color value for Secondary BG Color
     */
    fun getSecondaryBgColor(): Int {
        val color = PrefUtils.getThemeSecondaryBgColorInt()
        // Log.e("getSecondaryBgColor", "$color")
        return color
    } // getSecondaryBgColor

    /**
     * getPrimaryTextColor(): [Int]
     *
     * Retrieves color value of Primary Text Color
     *
     * @return [Int] that is the color value for Primary Text Color
     */
    fun getPrimaryTextColor(): Int {
        val color = PrefUtils.getThemePrimaryTextColorInt()
        // Log.e("getPrimaryTextColor", "$color")
        return color
    } // getPrimaryTextColor

    /**
     * getSecondaryTextColor(): [Int]
     *
     * Retrieves color value of Secondary Text Color
     *
     * @return [Int] that is the color value for Secondary Text Color
     */
    fun getSecondaryTextColor(): Int {
        val color = PrefUtils.getThemeSecondaryTextColorInt()
        // Log.e("getSecondaryTextColor", "$color")
        return color
    } // getSecondaryTextColor

    /**
     * isLightTheme(): [Boolean]
     *
     * Retrieves value of Day/Night Boolean
     *
     * @return [Boolean] that is true for light, and false or dark
     */
    fun isLightTheme(): Boolean {
        // Log.e("isLightTheme", getThemeHue().toString())
        return getThemeHue()
    }
} // Class
