package com.jb15613.themechooser.utility

import android.content.SharedPreferences
import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat
import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.startup.PrefUtilsInitializer


object PrefUtils {

    private var mPrefs: SharedPreferences
    private var mResources: Resources

    var isInitialized = false

    init {
        isInitialized = true
        mPrefs = PrefUtilsInitializer.mPrefs
        mResources = PrefUtilsInitializer.mResources
    }

    /*
    /**
     * setThemeName(themeName: [String])
     *
     * Saves name of Theme Color to [SharedPreferences]
     *
     * @param  themeName a [String] that will be saved as the theme name
     */
    fun setThemeName(themeName: String) {
        val editor = mPrefs.edit()
        editor.putString(PREF_THEME_NAME_KEY, themeName)
        editor.apply()
    } // setThemeName

    /**
     * getThemeName(themeName: [String])
     *
     * Gets name of Theme Color from [SharedPreferences]
     *
     * @return [String] that represents the Theme Name
     */
    fun getThemeName(): String {
        return mPrefs.getString(PREF_THEME_NAME_KEY, LIGHTBLUE).toString()
    } // getThemeName

    /**
     * setThemeNameHueless(themeName: [String])
     *
     * Saves name of Theme Color to [SharedPreferences]
     *
     * @param  themeName a [String] that will be saved as the theme name less hue
     */
    fun setThemeNameHueless(themeName: String) {
        val editor = mPrefs.edit()
        editor.putString(PREF_THEME_NAME_NOHUE_KEY, themeName)
        editor.apply()
    } // setThemeNameHueless

    /**
     * getThemeNameHueless(themeName: [String])
     *
     * Gets name of Theme Color from [SharedPreferences]
     *
     * @return [String] that represents the Theme Name less hue
     */
    fun getThemeNameHueless(): String {
        return mPrefs.getString(PREF_THEME_NAME_NOHUE_KEY, LIGHTBLUE).toString()
    } // getThemeNameHueless

    /**
     * setThemeColorString(themeName: [String])
     *
     * Saves name of theme color to prefs
     *
     * @param  themeName a [String] that will be saved as the theme name
     */
    fun setThemeColorString(themeName: String) {
        val editor = mPrefs.edit()
        editor.putString(PREF_THEME_KEY, themeName)
        editor.apply()
    } // setThemeColorString

    /**
     * getThemeColor(): String
     *
     * Retrieves name of theme color from prefs
     *
     * @return [String] that was saved as the theme name
     */
    fun getThemeColorString(): String {
        return mPrefs.getString(PREF_THEME_KEY, LIGHTBLUE).toString()
    } // getThemeColorString

    /**
     * setAccentColorString(accentName: [String])
     *
     * Saves name of accent color to prefs
     *
     * @param  accentName a [String] that will be saved as the accent name
     */
    fun setAccentColorString(accentName: String?) {
        val editor = mPrefs.edit()
        editor.putString(PREF_THEME_ACCENT_KEY, accentName)
        editor.apply()
    } // setAccentColorString

    /**
     * getAccentColorString(): String
     *
     * Retrieves name of accent color from prefs
     *
     * @return [String] that was saved as the accent name
     */
    fun getAccentColorString(): String? {
        return mPrefs.getString(PREF_THEME_ACCENT_KEY, LIGHTBLUE)
    } // getAccentColorString
     */

    /**
     * setThemeName(themeName: [String])
     *
     * Saves name of Theme Color to [SharedPreferences]
     *
     * @param  themeName a [String] that will be saved as the theme name
     */
    fun setThemeName(themeName: String) {

        /*
            Set Theme Name to prefs ->
            Set Theme Color Int to prefs ->
            Set Accent Color Int to prefs ->
            Set Theme Dark Color Int to prefs ->
            Set Text Color Ints to prefs ->
            Set BG Color Ints to prefs ->
            Set hue to prefs?
         */

        val editor = mPrefs.edit()
        editor.putString(PREF_THEME_NAME_KEY, themeName)
        editor.apply()

        val mAccentName: String

        if (themeName.contains(HUE_SPLITTER)) {
            // Contains Hue Splitter
            // Trying to make this go away
            val hueSplit: Array<String> = themeName.split(HUE_SPLITTER).toTypedArray()
            val hs1 = hueSplit[0]
            if (hs1.contains(THEME_SPLITTER)) {
                // Custom Accent Color

                // Isolate accent name
                val hs1split: List<String> = hs1.split(THEME_SPLITTER)
                mAccentName = hs1split[1]
                editor.putString(PREF_ACCENT_NAME_KEY, mAccentName)

                val colors: IntArray = ColorUtils.getColorSet(hs1, false)
                editor.putInt(PREF_THEME_COLOR_INT_KEY, colors[0])
                editor.putInt(PREF_THEME_DARK_COLOR_INT_KEY, colors[1])
                editor.putInt(PREF_THEME_ACCENT_COLOR_INT_KEY, colors[2])
                editor.apply()
            } else {
                // Matching Accent Color (A1)
                // True Color Set
                val accentLabel: String =
                    if (hs1 == BROWN || hs1 == GREY || hs1 == BLUEGREY) {
                        " 3"
                    } else {
                        " A1"
                    }

                mAccentName = "$hs1$accentLabel"
                editor.putString(PREF_ACCENT_NAME_KEY, mAccentName)
                val colors: IntArray = ColorUtils.getColorSet(hs1, true)
                editor.putInt(PREF_THEME_COLOR_INT_KEY, colors[0])
                editor.putInt(PREF_THEME_DARK_COLOR_INT_KEY, colors[1])
                editor.putInt(PREF_THEME_ACCENT_COLOR_INT_KEY, colors[2])
                editor.apply()
            }
        } else {
            // Does not contain Hue Splitter
            /* SHOULD NEVER HAPPEN */
            if (themeName.contains(THEME_SPLITTER)) {
                // Custom Accent Color
                val colors: IntArray = ColorUtils.getColorSet(themeName, false)
                editor.putInt(PREF_THEME_COLOR_INT_KEY, colors[0])
                editor.putInt(PREF_THEME_DARK_COLOR_INT_KEY, colors[1])
                editor.putInt(PREF_THEME_ACCENT_COLOR_INT_KEY, colors[2])
                editor.apply()
            } else {
                // Matching Accent Color (A1)
                // True Color Set
                val colors: IntArray = ColorUtils.getColorSet(themeName, true)
                editor.putInt(PREF_THEME_COLOR_INT_KEY, colors[0])
                editor.putInt(PREF_THEME_DARK_COLOR_INT_KEY, colors[1])
                editor.putInt(PREF_THEME_ACCENT_COLOR_INT_KEY, colors[2])
                editor.apply()
            }
        }

        if (themeName.contains(HUE_SPLITTER)) {
            val items: List<String> = themeName.split(HUE_SPLITTER)
            if (items[1].contains("Light")) {
                // Light Theme
                setLightThemeTextAndBgColors()
            } else {
                // Dark Theme
                setDarkThemeTextAndBgColors()
            }
        } else {
            // Dark Theme
            // SHOULD NEVER HAPPEN
            setDarkThemeTextAndBgColors()
        }

    } // setThemeName

    /**
     * setAccentName(): String
     *
     * Saves accent Name to [SharedPreferences]
     *
     * @param accentName a [String] that was saved as the accent name
     */
    fun setAccentName(accentName: String) {
        val editor = mPrefs.edit()
        editor.putString(PREF_ACCENT_NAME_KEY, accentName)
        editor.apply()
    } // setAccentName

    /**
     * getAccentName(): String
     *
     * Retrieves name of accent color from prefs
     *
     * @return [String] that was saved as the accent name
     */
    fun getAccentName(): String? {
        return mPrefs.getString(PREF_ACCENT_NAME_KEY, "Light Blue A1")
    } // getAccentName

    /**
     * setLightThemeTextAndBgColors()
     *
     * This function will save Text and Bg Colors for a Light Theme
     */
    private fun setLightThemeTextAndBgColors() {
        val editor = mPrefs.edit()
        // Text Colors
        editor.putInt(PREF_THEME_PRIMARY_TEXT_COLOR_INT_KEY, ResourcesCompat.getColor(mResources, R.color.textColorPrimaryInverse, null))
        editor.putInt(PREF_THEME_SECONDARY_TEXT_COLOR_INT_KEY, ResourcesCompat.getColor(mResources, R.color.textColorSecondaryInverse, null))
        editor.putInt(PREF_THEME_PRIMARY_TEXT_COLOR_INVERSE_INT_KEY, ResourcesCompat.getColor(mResources, R.color.textColorPrimary, null))
        editor.putInt(PREF_THEME_SECONDARY_TEXT_COLOR_INVERSE_INT_KEY, ResourcesCompat.getColor(mResources, R.color.textColorSecondary, null))

        // BG Colors
        editor.putInt(PREF_THEME_PRIMARY_BG_COLOR_INT_KEY, ResourcesCompat.getColor(mResources, R.color.primaryBgColorInverse, null))
        editor.putInt(PREF_THEME_SECONDARY_BG_COLOR_INT_KEY, ResourcesCompat.getColor(mResources, R.color.secondaryBgColorInverse, null))
        editor.putInt(PREF_THEME_PRIMARY_BG_COLOR_INVERSE_INT_KEY, ResourcesCompat.getColor(mResources, R.color.primaryBgColor, null))
        editor.putInt(PREF_THEME_SECONDARY_BG_COLOR_INVERSE_INT_KEY, ResourcesCompat.getColor(mResources, R.color.secondaryBgColor, null))

        editor.apply()
    } // setLightThemeTextAndBgColors

    /**
     * setDarkThemeTextAndBgColors()
     *
     * This function will save Text and Bg Colors for a Dark Theme
     */
    private fun setDarkThemeTextAndBgColors() {
        val editor = mPrefs.edit()
        // Text Colors
        editor.putInt(PREF_THEME_PRIMARY_TEXT_COLOR_INT_KEY, ResourcesCompat.getColor(mResources, R.color.textColorPrimary, null))
        editor.putInt(PREF_THEME_SECONDARY_TEXT_COLOR_INT_KEY, ResourcesCompat.getColor(mResources, R.color.textColorSecondary, null))
        editor.putInt(PREF_THEME_PRIMARY_TEXT_COLOR_INVERSE_INT_KEY, ResourcesCompat.getColor(mResources, R.color.textColorPrimaryInverse, null))
        editor.putInt(PREF_THEME_SECONDARY_TEXT_COLOR_INVERSE_INT_KEY, ResourcesCompat.getColor(mResources, R.color.textColorSecondaryInverse, null))

        // BG Colors
        editor.putInt(PREF_THEME_PRIMARY_BG_COLOR_INT_KEY, ResourcesCompat.getColor(mResources, R.color.primaryBgColor, null))
        editor.putInt(PREF_THEME_SECONDARY_BG_COLOR_INT_KEY, ResourcesCompat.getColor(mResources, R.color.secondaryBgColor, null))
        editor.putInt(PREF_THEME_PRIMARY_BG_COLOR_INVERSE_INT_KEY, ResourcesCompat.getColor(mResources, R.color.primaryBgColorInverse, null))
        editor.putInt(PREF_THEME_SECONDARY_BG_COLOR_INVERSE_INT_KEY, ResourcesCompat.getColor(mResources, R.color.secondaryBgColorInverse, null))

        editor.apply()
    } // setDarkThemeTextAndBgColors

    /**
     * getThemeName(themeName: [String])
     *
     * Gets name of Theme Color from [SharedPreferences]
     *
     * @return [String] that represents the Theme Name
     */
    fun getThemeName(): String {
        return mPrefs.getString(PREF_THEME_NAME_KEY, LIGHTBLUE).toString()
    } // getThemeName

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
     * setThemePrimaryBgInverseColorInt(themeColor: [Int])
     *
     * Saves Theme Primary BG Inverse Color to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Primary BG Inverse Color
     */
    fun setThemePrimaryBgInverseColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_PRIMARY_BG_COLOR_INVERSE_INT_KEY, themeColor)
        editor.apply()
    } // setThemePrimaryBgInverseColorInt

    /**
     * getThemePrimaryBgInverseColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the primary Bg Inverse color
     */
    fun getThemePrimaryBgInverseColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_PRIMARY_BG_COLOR_INVERSE_INT_KEY, 0)
    } // getThemePrimaryBgInverseColorInt

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
     * setThemeSecondaryBgInverseColorInt(themeColor: [Int])
     *
     * Saves Theme Secondary BG Inverse Color to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Secondary BG Inverse Color
     */
    fun setThemeSecondaryBgInverseColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_SECONDARY_BG_COLOR_INVERSE_INT_KEY, themeColor)
        editor.apply()
    } // setThemeSecondaryBgInverseColorInt

    /**
     * getThemeSecondaryBgInverseColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Secondary Bg Inverse color
     */
    fun getThemeSecondaryBgInverseColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_SECONDARY_BG_COLOR_INVERSE_INT_KEY, 0)
    } // getThemeSecondaryBgInverseColorInt

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
     * setThemePrimaryTextInverseColorInt(themeColor: [Int])
     *
     * Saves Theme Primary Text Color Inverse to [SharedPreferences]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Primary Text Color Inverse
     */
    fun setThemePrimaryTextInverseColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_PRIMARY_TEXT_COLOR_INVERSE_INT_KEY, themeColor)
        editor.apply()
    } // setThemePrimaryTextInverseColorInt

    /**
     * getThemePrimaryTextInverseColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Primary Text Inverse Color
     */
    fun getThemePrimaryTextInverseColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_PRIMARY_TEXT_COLOR_INVERSE_INT_KEY, 0)
    } // getThemePrimaryTextInverseColorInt

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

    /**
     * setThemeSecondaryTextInverseColorInt(themeColor: [Int])
     *
     * Saves Theme Secondary Text Color Inverse to [SharedPreferences]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Secondary Text Color Inverse
     */
    fun setThemeSecondaryTextInverseColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_PRIMARY_TEXT_COLOR_INVERSE_INT_KEY, themeColor)
        editor.apply()
    } // setThemeSecondaryTextInverseColorInt

    /**
     * getThemeSecondaryTextInverseColorInt(): [Int]
     *
     * Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Secondary Text Inverse Color
     */
    fun getThemeSecondaryTextInverseColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_PRIMARY_TEXT_COLOR_INVERSE_INT_KEY, 0)
    } // getThemeSecondaryTextInverseColorInt

} // Class
