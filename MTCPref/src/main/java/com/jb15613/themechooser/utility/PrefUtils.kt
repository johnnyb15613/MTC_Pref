package com.jb15613.themechooser.utility

import android.content.SharedPreferences
import com.jb15613.themechooser.startup.PrefUtilsInitializer


object PrefUtils {

    var mPrefs: SharedPreferences

    var isInitialized = false

    init {
        isInitialized = true
        mPrefs = PrefUtilsInitializer.mPrefs
    }

    /**
     * setThemeColor(themeName: [String])
     *
     * Saves name of theme color to prefs
     *
     * @param  themeName a [String] that will be saved as the theme name
     */
    fun setThemeColor(themeName: String) {
        val editor = mPrefs.edit()
        editor.putString(PREF_THEME_KEY, themeName)
        editor.apply()
    } // setThemeColor

    /**
     * getThemeColor(): String
     *
     * Retrieves name of theme color from prefs
     *
     * @return [String] that was saved as the theme name
     */
    fun getThemeColor(): String {
        return mPrefs.getString(PREF_THEME_KEY, LIGHTBLUE).toString()
    } // getThemeColor

    /**
     * setAccentColor(accentName: [String])
     *
     * Saves name of accent color to prefs
     *
     * @param  accentName a [String] that will be saved as the accent name
     */
    fun setAccentColor(accentName: String?) {
        val editor = mPrefs.edit()
        editor.putString(PREF_THEME_ACCENT_KEY, accentName)
        editor.apply()
    } // setAccentColor

    /**
     * getAccentColor(): String
     *
     * Retrieves name of accent color from prefs
     *
     * @return [String] that was saved as the accent name
     */
    fun getAccentColor(): String? {
        return mPrefs.getString(PREF_THEME_ACCENT_KEY, LIGHTBLUE)
    } // getAccentColor

    /**
     * setThemeHue(themeHue: [Boolean])
     *
     * Saves hue of theme color to prefs
     *
     * @param  themeHue a [Boolean] that will be saved as the theme hue
     */
    fun setThemeHue(themeHue: Boolean) {
        val editor = mPrefs.edit()
        editor.putBoolean(PREF_THEME_HUE_KEY, themeHue)
        editor.apply()
    } // setThemeHue

    /**
     * getThemeHue(): [Boolean]
     *
     * Retrieves name of theme hue from prefs
     *
     * @return [Boolean] that represents Theme Hue (Light = true : Dark = false)
     */
    fun getThemeHue(): Boolean {
        return mPrefs.getBoolean(PREF_THEME_HUE_KEY, false)
    } // getThemeHue

    /**
     * setDensityScale(scale: [Float])
     *
     * Saves the device density scale to prefs
     *
     * @param  scale a [Float] that will be saved as the density scale
     */
    fun setDensityScale(scale: Float) {
        val editor = mPrefs.edit()
        editor.putFloat(PREF_DENSITY_SCALE_KEY, scale)
        editor.apply()
    } // setDensityScale

    /**
     * getDensityScale(): [Float]
     *
     * Retrieves value of density scale from prefs
     *
     * @return [Float] that was saved as the density scale
     */
    fun getDensityScale(): Float {
        return mPrefs.getFloat(PREF_DENSITY_SCALE_KEY, 0f)
    } // getDensityScale

    /**
     * setCellSize(cellSize: [Int])
     *
     * Saves size of cells to prefs
     *
     * @param  cellSize an [Int] that will be saved as the cell size
     */
    fun setCellSize(cellSize: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_CELL_SIZE_KEY, cellSize)
        editor.apply()
    } // setCellSize

    /**
     * getCellSize(): [Int]
     *
     * Retrieves size of cells from prefs
     *
     * @return [Int] that was saved as the cell size
     */
    fun getCellSize(): Int {
        return mPrefs.getInt(PREF_CELL_SIZE_KEY, 0)
    } // getCellSize

    /**
     * setThemeColorInt(themeColor: [Int])
     *
     * Saves Theme Color to prefs as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the ThemeColor
     */
    fun setThemeColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemeColorInt

    /**
     * getThemeColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the ThemeColor
     */
    fun getThemeColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_COLOR_INT_KEY, 0)
    } // getThemeColorInt

    /**
     * setThemeDarkColorInt(themeColor: [Int])
     *
     * Saves Theme Dark Color to prefs as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the ThemeColor Dark
     */
    fun setThemeDarkColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_DARK_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemeDarkColorInt

    /**
     * getThemeDarkColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the ThemeColor
     */
    fun getThemeDarkColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_DARK_COLOR_INT_KEY, 0)
    } // getThemeDarkColorInt

    /**
     * setThemeAccentColorInt(themeColor: [Int])
     *
     * Saves Theme Accent Color to prefs as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Accent Color
     */
    fun setThemeAccentColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_ACCENT_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemeDarkColorInt

    /**
     * getThemeAccentColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Theme Accent Color
     */
    fun getThemeAccentColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_ACCENT_COLOR_INT_KEY, 0)
    } // getThemeAccentColorInt

    /**
     * setThemePrimaryBgColorInt(themeColor: [Int])
     *
     * Saves Theme Primary BG Color to prefs as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Primary BG Color
     */
    fun setThemePrimaryBgColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_PRIMARY_BG_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemePrimaryBgColorInt

    /**
     * getThemePrimaryBgColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the primary Bg color
     */
    fun getThemePrimaryBgColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_PRIMARY_BG_COLOR_INT_KEY, 0)
    } // getThemePrimaryBgColorInt

    /**
     * setThemeSecondaryBgColorInt(themeColor: [Int])
     *
     * Saves Theme Secondary BG Color to prefs as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Secondary BG Color
     */
    fun setThemeSecondaryBgColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_SECONDARY_BG_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemeSecondaryBgColorInt

    /**
     * getThemeSecondaryBgColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Secondary Bg color
     */
    fun getThemeSecondaryBgColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_SECONDARY_BG_COLOR_INT_KEY, 0)
    } // getThemeSecondaryBgColorInt

    /**
     * setThemePrimaryTextColorInt(themeColor: [Int])
     *
     * Saves Theme Primary Text Color to prefs as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Primary Text Color
     */
    fun setThemePrimaryTextColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_PRIMARY_TEXT_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemePrimaryTextColorInt

    /**
     * getThemePrimaryTextColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Primary Text color
     */
    fun getThemePrimaryTextColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_PRIMARY_TEXT_COLOR_INT_KEY, 0)
    } // getThemePrimaryTextColorInt

    /**
     * setThemeSecondaryTextColorInt(themeColor: [Int])
     *
     * Saves Theme Secondary Text Color to prefs as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Secondary Text Color
     */
    fun setThemeSecondaryTextColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_SECONDARY_TEXT_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemeSecondaryTextColorInt

    /**
     * getThemeSecondaryTextColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Secondary Text color
     */
    fun getThemeSecondaryTextColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_SECONDARY_TEXT_COLOR_INT_KEY, 0)
    } // getThemeSecondaryTextColorInt

} // Class
