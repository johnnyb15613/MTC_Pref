package com.jb15613.themechooser.utility

import android.content.Context
import android.content.SharedPreferences


object PrefUtils {
    /**
     * Saves name of theme color to prefs
     *
     * @param  context a `Context` that is used to retrieve a preference object
     * @param  themeName a `String` that will be saved as the theme name
     */
    fun setThemeColor(context: Context, themeName: String) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(PREF_THEME_KEY, themeName)
        editor.apply()
    } // setThemeColor

    /**
     * Retrieves name of theme color from prefs
     *
     * @param  context a `Context` that is used to retrieve a preference object
     *
     * @return  themeName a `String` that was saved as the theme name
     */
    fun getThemeColor(context: Context): String? {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        return prefs.getString(PREF_THEME_KEY, LIGHTBLUE)
    } // getThemeColor

    /**
     * Saves name of accent color to prefs
     *
     * @param  context a `Context` that is used to retrieve a preference object
     * @param  accentName a `String` that will be saved as the accent name
     */
    fun setAccentColor(context: Context, accentName: String?) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putString(PREF_THEME_ACCENT_KEY, accentName)
        editor.apply()
    } // setAccentColor

    /**
     * Retrieves name of accent color from prefs
     *
     * @param  context a `Context` that is used to retrieve a preference object
     *
     * @return  acventName a `String` that was saved as the accent name
     */
    fun getAccentColor(context: Context): String? {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        return prefs.getString(PREF_THEME_ACCENT_KEY, LIGHTBLUE)
    } // getAccentColor

    /**
     * Saves hue of theme color to prefs
     *
     * @param  context a `Context` that is used to retrieve a preference object
     * @param  themeHue a `Boolean` that will be saved as the theme hue
     */
    fun setThemeHue(context: Context, themeHue: Boolean) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putBoolean(PREF_THEME_HUE_KEY, themeHue)
        editor.apply()
    } // setThemeHue

    /**
     * Retrieves name of theme hue from prefs
     *
     * @param  context a `Context` that is used to retrieve a preference object
     *
     * @return  themeHue a `Boolean` that was saved as the theme hue
     */
    fun getThemeHue(context: Context): Boolean {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        return prefs.getBoolean(PREF_THEME_HUE_KEY, false)
    } // getThemeHue

    /**
     * Saves the device dendity scale to prefs
     *
     * @param  context a `Context` that is used to retrieve a preference object
     * @param  scale a `float` that will be saved as the density scale
     */
    fun setDensityScale(context: Context, scale: Float) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putFloat(PREF_DENSITY_SCALE_KEY, scale)
        editor.apply()
    } // setDensityScale

    /**
     * Retrieves value of density scsle from prefs
     *
     * @param  context a `Context` that is used to retrieve a preference object
     *
     * @return  scale a `float` that was saved as the density scale
     */
    fun getDensityScale(context: Context): Float {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        return prefs.getFloat(PREF_DENSITY_SCALE_KEY, 0f)
    } // getDensityScale

    /**
     * Saves size of cells to prefs
     *
     * @param  context a `Context` that is used to retrieve a preference object
     * @param  cellSize an `int` that will be saved as the cell size
     */
    fun setCellSize(context: Context, cellSize: Int) {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        val editor = prefs.edit()
        editor.putInt(PREF_CELL_SIZE_KEY, cellSize)
        editor.apply()
    } // setCellSize

    /**
     * Retrieves size of cells from prefs
     *
     * @param  context a `Context` that is used to retrieve a preference object
     *
     * @return  cellSize an `int` that was saved as the cell size
     */
    fun getCellSize(context: Context): Int {
        val prefs: SharedPreferences =
            context.getSharedPreferences(PREF_NAME_KEY, Context.MODE_PRIVATE)
        return prefs.getInt(PREF_CELL_SIZE_KEY, 0)
    } // getCellSize
} // Class
