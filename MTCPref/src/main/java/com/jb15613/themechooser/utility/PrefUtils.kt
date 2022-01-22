package com.jb15613.themechooser.utility

import android.content.SharedPreferences
import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat
import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.startup.PrefUtilsInitializer

/**
## Utilities for Working With [SharedPreferences]
 */
object PrefUtils {

    private var mPrefs: SharedPreferences
    private var mResources: Resources

    var isInitialized = false

    init {
        isInitialized = true
        mPrefs = PrefUtilsInitializer.mPrefs
        mResources = PrefUtilsInitializer.mResources
    }

    /**
     ## setThemeName(themeName: [String])

     ### Saves all needed Theme Info into [SharedPreferences]
     ```
      themeName: [String]
      accentName: [String]
      themeColorInt: [Int]
      themeDarkColorInt: [Int]
      themeAccentColorInt: [Int]
      textColorPrimaryInt: [Int]
      textColorPrimaryInverseInt: [Int]
      textColorSecondaryInt: [Int]
      textColorSecondaryInverseInt: [Int]
      bgColorPrimaryInt: [Int]
      bgColorPrimaryInverseInt: [Int]
      bgColorSecondaryInt: [Int]
      bgColorSecondaryInverseInt: [Int]
     ```
     * @param  themeName a [String] that will be saved as the theme name
     */
    fun setThemeName(themeName: String) {

        val editor = mPrefs.edit()
        editor.putString(PREF_THEME_NAME_KEY, themeName)
        editor.apply()

        val mAccentName: String

        if (themeName.contains(HUE_SPLITTER)) {
            // Contains Hue Splitter
            val hueSplit: Array<String> = themeName.split(HUE_SPLITTER).toTypedArray()
            val hs1 = hueSplit[0]
            if (hs1.contains(THEME_SPLITTER)) {
                // Custom Accent Color

                // Isolate accent name
                val hs1split: List<String> = hs1.split(THEME_SPLITTER)
                mAccentName = hs1split[1]
                setAccentName(mAccentName)

                val colors: IntArray = ColorUtils.getColorSet(hs1, false)
                setThemeColorInt(colors[0])
                setThemeDarkColorInt(colors[1])
                setThemeAccentColorInt(colors[2])
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
                setAccentName(mAccentName)
                val colors: IntArray = ColorUtils.getColorSet(hs1, true)
                setThemeColorInt(colors[0])
                setThemeDarkColorInt(colors[1])
                setThemeAccentColorInt(colors[2])
            }
        } else {
            // Does not contain Hue Splitter
            /* SHOULD NEVER HAPPEN */
            if (themeName.contains(THEME_SPLITTER)) {
                // Custom Accent Color
                val colors: IntArray = ColorUtils.getColorSet(themeName, false)
                setThemeColorInt(colors[0])
                setThemeDarkColorInt(colors[1])
                setThemeAccentColorInt(colors[2])
            } else {
                // Matching Accent Color (A1)
                // True Color Set
                val colors: IntArray = ColorUtils.getColorSet(themeName, true)
                setThemeColorInt(colors[0])
                setThemeDarkColorInt(colors[1])
                setThemeAccentColorInt(colors[2])
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
     ## setAccentName(accentName: String)
     *
     ### Saves accent Name to [SharedPreferences]
     *
     * @param accentName a [String] that was saved as the accent name
     */
    private fun setAccentName(accentName: String) {
        val editor = mPrefs.edit()
        editor.putString(PREF_ACCENT_NAME_KEY, accentName)
        editor.apply()
    } // setAccentName

    /**
     ## getAccentName(): String
     *
     ### Retrieves name of accent color from prefs
     *
     * @return [String] that was saved as the accent name
     */
    fun getAccentName(): String? {
        return mPrefs.getString(PREF_ACCENT_NAME_KEY, "Light Blue A1")
    } // getAccentName

    /**
     ## setLightThemeTextAndBgColors()
     *
     ### This function will save Text and Bg Colors for a Light Theme
     */
    private fun setLightThemeTextAndBgColors() {
        // Text Colors
        setThemePrimaryTextColorInt(ResourcesCompat.getColor(mResources, R.color.textColorPrimaryInverse, null))
        setThemeSecondaryTextColorInt(ResourcesCompat.getColor(mResources, R.color.textColorSecondaryInverse, null))
        setThemePrimaryTextInverseColorInt(ResourcesCompat.getColor(mResources, R.color.textColorPrimary, null))
        setThemeSecondaryTextInverseColorInt(ResourcesCompat.getColor(mResources, R.color.textColorSecondary, null))

        // BG Colors
        setThemePrimaryBgColorInt(ResourcesCompat.getColor(mResources, R.color.primaryBgColorInverse, null))
        setThemeSecondaryBgColorInt(ResourcesCompat.getColor(mResources, R.color.secondaryBgColorInverse, null))
        setThemePrimaryBgInverseColorInt(ResourcesCompat.getColor(mResources, R.color.primaryBgColor, null))
        setThemeSecondaryBgInverseColorInt(ResourcesCompat.getColor(mResources, R.color.secondaryBgColor, null))

    } // setLightThemeTextAndBgColors

    /**
     ## setDarkThemeTextAndBgColors()
     *
     ### This function will save Text and Bg Colors for a Dark Theme
     */
    private fun setDarkThemeTextAndBgColors() {
        // Text Colors
        setThemePrimaryTextColorInt(ResourcesCompat.getColor(mResources, R.color.textColorPrimary, null))
        setThemeSecondaryTextColorInt(ResourcesCompat.getColor(mResources, R.color.textColorSecondary, null))
        setThemePrimaryTextInverseColorInt(ResourcesCompat.getColor(mResources, R.color.textColorPrimaryInverse, null))
        setThemeSecondaryTextInverseColorInt(ResourcesCompat.getColor(mResources, R.color.textColorSecondaryInverse, null))

        // BG Colors
        setThemePrimaryBgColorInt(ResourcesCompat.getColor(mResources, R.color.primaryBgColor, null))
        setThemeSecondaryBgColorInt(ResourcesCompat.getColor(mResources, R.color.secondaryBgColor, null))
        setThemePrimaryBgInverseColorInt(ResourcesCompat.getColor(mResources, R.color.primaryBgColorInverse, null))
        setThemeSecondaryBgInverseColorInt(ResourcesCompat.getColor(mResources, R.color.secondaryBgColorInverse, null))

    } // setDarkThemeTextAndBgColors

    /**
     ## getThemeName(themeName: [String])
     *
     ### Gets name of Theme Color from [SharedPreferences]
     *
     * @return [String] that represents the Theme Name
     */
    fun getThemeName(): String {
        return mPrefs.getString(PREF_THEME_NAME_KEY, LIGHTBLUE + HUE_SPLITTER + "Dark").toString()
    } // getThemeName

    /**
     ## setThemeHue(themeHue: [Boolean])
     *
     ### Saves hue of theme color to [SharedPreferences]
     *
     * @param  themeHue a [Boolean] that will be saved as the theme hue
     - true : Light Theme
     - false : Dark Theme
     */
    fun setThemeHue(themeHue: Boolean) {
        val editor = mPrefs.edit()
        editor.putBoolean(PREF_THEME_HUE_KEY, themeHue)
        editor.apply()
    } // setThemeHue

    /**
     ## getThemeHue(): [Boolean]
     *
     ### Retrieves name of theme hue from [SharedPreferences]
     *
     * @return [Boolean] that represents Theme Hue (Light = true : Dark = false)
     */
    fun getThemeHue(): Boolean {
        return mPrefs.getBoolean(PREF_THEME_HUE_KEY, false)
    } // getThemeHue

    /**
     ## setDensityScale(scale: [Float])
     *
     ### Saves the device density scale to [SharedPreferences]
     *
     * @param  scale a [Float] that will be saved as the density scale
     */
    fun setDensityScale(scale: Float) {
        val editor = mPrefs.edit()
        editor.putFloat(PREF_DENSITY_SCALE_KEY, scale)
        editor.apply()
    } // setDensityScale

    /**
     ## getDensityScale(): [Float]
     *
     ### Retrieves value of density scale from [SharedPreferences]
     *
     * @return [Float] that was saved as the density scale
     */
    fun getDensityScale(): Float {
        return mPrefs.getFloat(PREF_DENSITY_SCALE_KEY, 0f)
    } // getDensityScale

    /**
     ## setCellSize(cellSize: [Int])
     *
     ### Saves size of cells to [SharedPreferences]
     *
     * @param  cellSize an [Int] that will be saved as the cell size
     */
    fun setCellSize(cellSize: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_CELL_SIZE_KEY, cellSize)
        editor.apply()
    } // setCellSize

    /**
     ## getCellSize(): [Int]
     *
     ### Retrieves size of cells from [SharedPreferences]
     *
     * @return [Int] that was saved as the cell size
     */
    fun getCellSize(): Int {
        return mPrefs.getInt(PREF_CELL_SIZE_KEY, 0)
    } // getCellSize

    /**
     ## setThemeColorInt(themeColor: [Int])
     *
     ### Saves Theme Color to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the ThemeColor
     */
    private fun setThemeColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemeColorInt

    /**
     ## getThemeColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the ThemeColor
     */
    fun getThemeColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_COLOR_INT_KEY, 0)
    } // getThemeColorInt

    /**
     ## setThemeDarkColorInt(themeColor: [Int])
     *
     ### Saves Theme Dark Color to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the ThemeColor Dark
     */
    private fun setThemeDarkColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_DARK_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemeDarkColorInt

    /**
     ## getThemeDarkColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the ThemeColor
     */
    fun getThemeDarkColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_DARK_COLOR_INT_KEY, 0)
    } // getThemeDarkColorInt

    /**
     ## setThemeAccentColorInt(themeColor: [Int])
     *
     ### Saves Theme Accent Color to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Accent Color
     */
    private fun setThemeAccentColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_ACCENT_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemeDarkColorInt

    /**
     ## getThemeAccentColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Theme Accent Color
     */
    fun getThemeAccentColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_ACCENT_COLOR_INT_KEY, 0)
    } // getThemeAccentColorInt

    /**
     ## setThemePrimaryBgColorInt(themeColor: [Int])
     *
     ### Saves Theme Primary BG Color to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Primary BG Color
     */
    private fun setThemePrimaryBgColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_PRIMARY_BG_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemePrimaryBgColorInt

    /**
     ## getThemePrimaryBgColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the primary Bg color
     */
    fun getThemePrimaryBgColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_PRIMARY_BG_COLOR_INT_KEY, 0)
    } // getThemePrimaryBgColorInt

    /**
     ## setThemePrimaryBgInverseColorInt(themeColor: [Int])
     *
     ### Saves Theme Primary BG Inverse Color to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Primary BG Inverse Color
     */
    private fun setThemePrimaryBgInverseColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_PRIMARY_BG_COLOR_INVERSE_INT_KEY, themeColor)
        editor.apply()
    } // setThemePrimaryBgInverseColorInt

    /**
     ## getThemePrimaryBgInverseColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the primary Bg Inverse color
     */
    fun getThemePrimaryBgInverseColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_PRIMARY_BG_COLOR_INVERSE_INT_KEY, 0)
    } // getThemePrimaryBgInverseColorInt

    /**
     ## setThemeSecondaryBgColorInt(themeColor: [Int])
     *
     ### Saves Theme Secondary BG Color to prefs as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Secondary BG Color
     */
    private fun setThemeSecondaryBgColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_SECONDARY_BG_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemeSecondaryBgColorInt

    /**
     ## getThemeSecondaryBgColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Secondary Bg color
     */
    fun getThemeSecondaryBgColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_SECONDARY_BG_COLOR_INT_KEY, 0)
    } // getThemeSecondaryBgColorInt

    /**
     ## setThemeSecondaryBgInverseColorInt(themeColor: [Int])
     *
     ### Saves Theme Secondary BG Inverse Color to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Secondary BG Inverse Color
     */
    private fun setThemeSecondaryBgInverseColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_SECONDARY_BG_COLOR_INVERSE_INT_KEY, themeColor)
        editor.apply()
    } // setThemeSecondaryBgInverseColorInt

    /**
     ## getThemeSecondaryBgInverseColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Secondary Bg Inverse color
     */
    fun getThemeSecondaryBgInverseColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_SECONDARY_BG_COLOR_INVERSE_INT_KEY, 0)
    } // getThemeSecondaryBgInverseColorInt

    /**
     ## setThemePrimaryTextColorInt(themeColor: [Int])
     *
     ### Saves Theme Primary Text Color to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Primary Text Color
     */
    private fun setThemePrimaryTextColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_PRIMARY_TEXT_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemePrimaryTextColorInt

    /**
     ## getThemePrimaryTextColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Primary Text color
     */
    fun getThemePrimaryTextColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_PRIMARY_TEXT_COLOR_INT_KEY, 0)
    } // getThemePrimaryTextColorInt

    /**
     ## setThemePrimaryTextInverseColorInt(themeColor: [Int])
     *
     ### Saves Theme Primary Text Color Inverse to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Primary Text Color Inverse
     */
    private fun setThemePrimaryTextInverseColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_PRIMARY_TEXT_COLOR_INVERSE_INT_KEY, themeColor)
        editor.apply()
    } // setThemePrimaryTextInverseColorInt

    /**
     ## getThemePrimaryTextInverseColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Primary Text Inverse Color
     */
    fun getThemePrimaryTextInverseColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_PRIMARY_TEXT_COLOR_INVERSE_INT_KEY, 0)
    } // getThemePrimaryTextInverseColorInt

    /**
     ## setThemeSecondaryTextColorInt(themeColor: [Int])
     *
     ### Saves Theme Secondary Text Color to prefs as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Secondary Text Color
     */
    private fun setThemeSecondaryTextColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_SECONDARY_TEXT_COLOR_INT_KEY, themeColor)
        editor.apply()
    } // setThemeSecondaryTextColorInt

    /**
     ## getThemeSecondaryTextColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Secondary Text color
     */
    fun getThemeSecondaryTextColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_SECONDARY_TEXT_COLOR_INT_KEY, 0)
    } // getThemeSecondaryTextColorInt

    /**
     ## setThemeSecondaryTextInverseColorInt(themeColor: [Int])
     *
     ### Saves Theme Secondary Text Color Inverse to [SharedPreferences] as [Int]
     *
     * @param  themeColor an [Int] that will be saved as the Theme Secondary Text Color Inverse
     */
    private fun setThemeSecondaryTextInverseColorInt(themeColor: Int) {
        val editor = mPrefs.edit()
        editor.putInt(PREF_THEME_SECONDARY_TEXT_COLOR_INVERSE_INT_KEY, themeColor)
        editor.apply()
    } // setThemeSecondaryTextInverseColorInt

    /**
     ## getThemeSecondaryTextInverseColorInt(): [Int]
     *
     ### Gets color as [Int] from [SharedPreferences]
     *
     * @return [Int] that represents the Secondary Text Inverse Color
     */
    fun getThemeSecondaryTextInverseColorInt(): Int {
        return mPrefs.getInt(PREF_THEME_SECONDARY_TEXT_COLOR_INVERSE_INT_KEY, 0)
    } // getThemeSecondaryTextInverseColorInt

} // Class
