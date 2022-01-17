package com.jb15613.themechooser.utility

import android.content.SharedPreferences
import android.content.res.Resources
import android.util.Log
import androidx.core.content.res.ResourcesCompat
import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.startup.ColorPrefUtilsInitializer
import com.jb15613.themechooser.utility.PrefUtils.setThemeAccentColorInt
import com.jb15613.themechooser.utility.PrefUtils.setThemeColorInt
import com.jb15613.themechooser.utility.PrefUtils.setThemeDarkColorInt
import com.jb15613.themechooser.utility.PrefUtils.setThemeHue
import com.jb15613.themechooser.utility.PrefUtils.setThemePrimaryBgColorInt
import com.jb15613.themechooser.utility.PrefUtils.setThemePrimaryTextColorInt
import com.jb15613.themechooser.utility.PrefUtils.setThemeSecondaryBgColorInt
import com.jb15613.themechooser.utility.PrefUtils.setThemeSecondaryTextColorInt

object ColorPrefUtils {

    private var mResources: Resources

    var isInitialized = false

    init {
        isInitialized = true
        mResources = ColorPrefUtilsInitializer.mResources
    }

    fun setThemeColorsToPrefs(themeName: String, callingMethod: String) {

        /*
            themeName = Deep Purple
            themeName = Indigo - Dark
            themeName = Indigo - Light
            themeName = Cyan & Red
            themeName = Cyan & Red A1 - Dark
         */

        Log.e("setThemeColorToPrefs", "themeName : $themeName\nCalling Method: $callingMethod")

        var tN = themeName
        val isLightTheme = ThemeChooserUtils.isLightTheme()

        if (themeName.contains(HUE_SPLITTER)) {
            // dark/light specified
            // figure out which one to use
            val tn: Array<String> = themeName.split(HUE_SPLITTER).toTypedArray()
            tN = tn[0]
        }

        if (!isLightTheme) {
            // Dark Theme

            // set Text Colors in PrefUtils
            setThemePrimaryTextColorInt(ResourcesCompat.getColor(mResources, R.color.textColorPrimary, null))
            setThemeSecondaryTextColorInt(ResourcesCompat.getColor(mResources, R.color.textColorSecondary, null))
            // set BG Colors in PrefUtils
            setThemePrimaryBgColorInt(ResourcesCompat.getColor(mResources, R.color.primaryBgColor, null))
            setThemeSecondaryBgColorInt(ResourcesCompat.getColor(mResources, R.color.secondaryBgColor, null))

        } else {
            // Light Theme

            // set Text Colors in PrefUtils
            setThemePrimaryTextColorInt(ResourcesCompat.getColor(mResources, R.color.textColorPrimaryInverse, null))
            setThemeSecondaryTextColorInt(ResourcesCompat.getColor(mResources, R.color.textColorSecondaryInverse, null))
            // set BG Colors in PrefUtils
            setThemePrimaryBgColorInt(ResourcesCompat.getColor(mResources, R.color.primaryBgColorInverse, null))
            setThemeSecondaryBgColorInt(ResourcesCompat.getColor(mResources, R.color.secondaryBgColorInverse, null))

        } // if theme is dark or light

        val items: IntArray = if (tN.contains(THEME_SPLITTER)) {
            // Custom Color Theme
            // Purple & Orange A2
            ColorUtils.getColorSet(tN, true)
        } else {
            // Default Color Theme
            // Purple
            ColorUtils.getColorSet(tN, false)
        } // if theme contains "-"

        // set Theme Colors in PrefUtils
        setThemeColorInt(items[0])
        setThemeDarkColorInt(items[1])
        setThemeAccentColorInt(items[2])

    } // setThemeColorsToPrefs

} // Class