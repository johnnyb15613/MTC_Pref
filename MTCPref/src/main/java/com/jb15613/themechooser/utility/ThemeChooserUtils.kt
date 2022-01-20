package com.jb15613.themechooser.utility

import android.graphics.Color


/**
 * object ThemeChooserUtils
 *
 * Class that holds all public endpoints for usage with the Library
 *
 */
object ThemeChooserUtils {

    /**
     * getThemeColor(vararg opacities: Float): [Int]
     *
     * Retrieves color value of Primary Theme Color
     *
     * @param opacities an optional [Float] used to derive opaqueness for semi-transparent coloring
     *
     * @return [Int] that is the color value for Primary Theme Color
     */
    fun getThemeColor(vararg opacities: Float): Int {

        val themeColor = PrefUtils.getThemeColorInt()

        val arraySize = opacities.size

        if (arraySize == 0) {
            return themeColor
        } else {
            val opacity = opacities[0]
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
            return color
        } // if array is empty or not
    } // getThemeColor

    /**
     * getThemeDarkColor(): [Int]
     *
     * Retrieves color value of Primary Theme Color Dark
     *
     * @param opacities an optional [Float] used to derive opaqueness for semi-transparent coloring
     *
     * @return [Int] that is the color value for Primary Theme Color Dark
     */
    fun getThemeDarkColor(vararg opacities: Float): Int {
        val themeColor = PrefUtils.getThemeDarkColorInt()

        val arraySize = opacities.size

        if (arraySize == 0) {
            return themeColor
        } else {
            val opacity = opacities[0]
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
            return color
        }
    } // getThemeDarkColor

    /**
     * getThemeAccentColor(): [Int]
     *
     * Retrieves color value of Accent Theme Color
     *
     * @param opacities an optional [Float] used to derive opaqueness for semi-transparent coloring
     *
     * @return [Int] that is the color value for Accent Theme Color
     */
    fun getThemeAccentColor(vararg opacities: Float): Int {
        val themeAccentColor = PrefUtils.getThemeAccentColorInt()

        val arraySize = opacities.size

        if (arraySize == 0) {
            return themeAccentColor
        } else {
            val opacity = opacities[0]
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
            return color
        }
    } // getThemeAccentColor

    /**
     * getPrimaryBgColor(): [Int]
     *
     * Retrieves color value of Primary BG Color
     *
     * @return [Int] that is the color value for Primary BG Color
     */
    fun getPrimaryBgColor(): Int {
        return PrefUtils.getThemePrimaryBgColorInt()
    } // getPrimaryBgColor

    /**
     * getSecondaryBgColor(): [Int]
     *
     * Retrieves color value of Secondary BG Color
     *
     * @return [Int] that is the color value for Secondary BG Color
     */
    fun getSecondaryBgColor(): Int {
        return PrefUtils.getThemeSecondaryBgColorInt()
    } // getSecondaryBgColor

    /**
     * getPrimaryBgInverseColor(): [Int]
     *
     * Retrieves color value of Primary BG Inverse Color
     *
     * @return [Int] that is the color value for Primary BG Inverse Color
     */
    fun getPrimaryBgInverseColor(): Int {
        return PrefUtils.getThemePrimaryBgInverseColorInt()
    } // getPrimaryBgInverseColor

    /**
     * getSecondaryBgInverseColor(): [Int]
     *
     * Retrieves color value of Secondary BG Inverse Color
     *
     * @return [Int] that is the color value for Secondary BG Inverse Color
     */
    fun getSecondaryBgInverseColor(): Int {
        return PrefUtils.getThemeSecondaryBgInverseColorInt()
    } // getSecondaryBgInverseColor

    /**
     * getPrimaryTextColor(): [Int]
     *
     * Retrieves color value of Primary Text Color
     *
     * @return [Int] that is the color value for Primary Text Color
     */
    fun getPrimaryTextColor(): Int {
        return PrefUtils.getThemePrimaryTextColorInt()
    } // getPrimaryTextColor

    /**
     * getSecondaryTextColor(): [Int]
     *
     * Retrieves color value of Secondary Text Color
     *
     * @return [Int] that is the color value for Secondary Text Color
     */
    fun getSecondaryTextColor(): Int {
        return PrefUtils.getThemeSecondaryTextColorInt()
    } // getSecondaryTextColor

    /**
     * getPrimaryInverseTextColor(): [Int]
     *
     * Retrieves color value of Primary Inverse Text Color
     *
     * @return [Int] that is the color value for Primary Inverse Text Color
     */
    fun getPrimaryInverseTextColor(): Int {
        return PrefUtils.getThemePrimaryTextInverseColorInt()
    } // getPrimaryInverseTextColor

    /**
     * getSecondaryInverseTextColor(): [Int]
     *
     * Retrieves color value of Secondary Inverse Text Color
     *
     * @return [Int] that is the color value for Secondary Inverse Text Color
     */
    fun getSecondaryInverseTextColor(): Int {
        return PrefUtils.getThemeSecondaryTextInverseColorInt()
    } // getSecondaryTextColor

    /**
     * isLightTheme(): [Boolean]
     *
     * Retrieves value of Day/Night Boolean
     *
     * @return [Boolean] that is true for light, and false or dark
     */
    fun isLightTheme(): Boolean {
        return PrefUtils.getThemeHue()
    }
} // Class
