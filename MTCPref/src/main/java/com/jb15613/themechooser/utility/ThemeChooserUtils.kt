package com.jb15613.themechooser.utility

import android.content.res.Resources
import android.graphics.Color
import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.mtcpref.Themes
import com.jb15613.themechooser.startup.PrefUtilsInitializer
import com.jb15613.themechooser.utility.ColorStringIntSwitcher.switchColorToInt
import com.jb15613.themechooser.utility.color.AccentColor


/**
 ## ThemeChooserUtils
 *
 ### Class that holds all *Public* endpoints for usage with the Library

 Available Methods:
 ```
 getThemeColor(vararg opacity: Float): Int
 getThemeDarkColor(vararg opacity: Float): Int
 getThemeAccentColor(vararg opacity: Float): Int
 getPrimaryBgColor(): Int
 getPrimaryBgInverseColor(): Int
 getSecondaryBgColor(): Int
 getSecondaryBgInverseColor(): Int
 getPrimaryTextColor(): Int
 getPrimaryInverseTextColor(): Int
 getSecondaryTextColor(): Int
 getSecondaryInverseTextColor(): Int
 getThemeHue(): Boolean
 getColorAsHtmlString(color: Int): String
 getColorNameAsString(type: String): String
 getRandomThemeColor(): Int
 getRandomAccentColor(): Int
 ```
 *
 */
object ThemeChooserUtils {

    private var mResources: Resources

    var isInitialized = false

    init {
        isInitialized = true
        mResources = PrefUtilsInitializer.mResources
    }

    /**
     ## getThemeColor(*vararg* opacities: Float): [Int]
     *
     #### Retrieves color value of Primary Theme Color
     *
     * @param opacities an *optional* [Float] used to derive opaqueness for semi-transparent coloring
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
     ## getThemeDarkColor(*vararg* opacities: [Float]): [Int]
     *
     #### Retrieves color value of Primary Theme Color Dark
     *
     * @param opacities an *optional* [Float] used to derive opaqueness for semi-transparent coloring
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
     ## getThemeAccentColor(*vararg* opacities: [Float]): [Int]
     *
     #### Retrieves color value of Accent Theme Color
     *
     * @param opacities an *optional* [Float] used to derive opaqueness for semi-transparent coloring
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
     ## getPrimaryBgColor(): [Int]
     *
     #### Retrieves color value of Primary BG Color
     *
     * @return [Int] that is the color value for Primary BG Color
     */
    fun getPrimaryBgColor(): Int {
        return PrefUtils.getThemePrimaryBgColorInt()
    } // getPrimaryBgColor

    /**
     ## getSecondaryBgColor(): [Int]
     *
     #### Retrieves color value of Secondary BG Color
     *
     * @return [Int] that is the color value for Secondary BG Color
     */
    fun getSecondaryBgColor(): Int {
        return PrefUtils.getThemeSecondaryBgColorInt()
    } // getSecondaryBgColor

    /**
     ## getPrimaryBgInverseColor(): [Int]
     *
     #### Retrieves color value of Primary BG Inverse Color
     *
     * @return [Int] that is the color value for Primary BG Inverse Color
     */
    fun getPrimaryBgInverseColor(): Int {
        return PrefUtils.getThemePrimaryBgInverseColorInt()
    } // getPrimaryBgInverseColor

    /**
     ## getSecondaryBgInverseColor(): [Int]
     *
     #### Retrieves color value of Secondary BG Inverse Color
     *
     * @return [Int] that is the color value for Secondary BG Inverse Color
     */
    fun getSecondaryBgInverseColor(): Int {
        return PrefUtils.getThemeSecondaryBgInverseColorInt()
    } // getSecondaryBgInverseColor

    /**
     ## getPrimaryTextColor(): [Int]
     *
     #### Retrieves color value of Primary Text Color
     *
     * @return [Int] that is the color value for Primary Text Color
     */
    fun getPrimaryTextColor(): Int {
        return PrefUtils.getThemePrimaryTextColorInt()
    } // getPrimaryTextColor

    /**
     ## getSecondaryTextColor(): [Int]
     *
     #### Retrieves color value of Secondary Text Color
     *
     * @return [Int] that is the color value for Secondary Text Color
     */
    fun getSecondaryTextColor(): Int {
        return PrefUtils.getThemeSecondaryTextColorInt()
    } // getSecondaryTextColor

    /**
     ## getPrimaryInverseTextColor(): [Int]
     *
     #### Retrieves color value of Primary Inverse Text Color
     *
     * @return [Int] that is the color value for Primary Inverse Text Color
     */
    fun getPrimaryInverseTextColor(): Int {
        return PrefUtils.getThemePrimaryTextInverseColorInt()
    } // getPrimaryInverseTextColor

    /**
     ## getSecondaryInverseTextColor(): [Int]
     *
     #### Retrieves color value of Secondary Inverse Text Color
     *
     * @return [Int] that is the color value for Secondary Inverse Text Color
     */
    fun getSecondaryInverseTextColor(): Int {
        return PrefUtils.getThemeSecondaryTextInverseColorInt()
    } // getSecondaryTextColor

    /**
     ## getThemeHue(): [Boolean]
     *
     #### Retrieves value of Day/Night Boolean
     *
     * @return [Boolean] that is true for light, and false or dark
     */
    fun getThemeHue(): Boolean {
        return PrefUtils.getThemeHue()
    } // getThemeHue

    /**
     ## getColorAsHtmlString(color: [Int]): [String]
     *
     #### Retrieves a color in the form of an HTML [String]
     *
     * @param color An Int that represents the color
     *
     * @return [String] that contains the formatted color for use in HTML
     */
    fun getColorAsHtmlString(color: Int): String {
        val s = Integer.toHexString(color)
        return "#$s"
    } // getColorAsHtmlString

    /**
        ## getColorNameAsString(type: [String]): [String]

        #### Retrieves a color name in the form of a [String]

        #### Possible Args for [type]:
        ```
         - Theme
         - ThemeDark
         - Accent
         - PrimaryBg
         - SecondaryBg
         - PrimaryText
         - SecondaryText
         ```

      *  @param [type] a [String] that represents the color being requested

      *  @return [String] that contains the color as a name

     */
    fun getColorNameAsString(type: String): String {

        val isUnitTest = TestUtils.isRunningUnitTest()

        // Get Theme Name
        val themeName: String = if (isUnitTest) {
            "Deep Purple & Blue Grey 3 - Dark"
        } else {
            PrefUtils.getThemeName()
        }

        var tName = ""
        var aName = ""
        var hName = ""

        var pBgName = ""
        var sBgName = ""

        var pTxName = ""
        var sTxName = ""

        // Split it at the Hue
        if (themeName.contains(HUE_SPLITTER)) {
            // SHOULD ALWAYS BE TRUE
            val hueSplit: List<String> = themeName.split(HUE_SPLITTER)
            hName = hueSplit[1]
            if (hueSplit[0].contains(THEME_SPLITTER)) {
                val themeSplit: List<String> = hueSplit[0].split(THEME_SPLITTER)
                tName = themeSplit[0]
                aName = themeSplit[1]
            } else {
                tName = hueSplit[0]

                val accentLabel: String =
                    if (tName == BROWN || tName == GREY || tName == BLUEGREY) {
                        " 3"
                    } else {
                        " A1"
                    }
                aName = "$tName$accentLabel"
            }
        }

        when (hName) {
            "Dark" -> {
                pBgName = "Grey #30"
                sBgName = "Grey #42"
                pTxName = "White"
                sTxName = "Opaque White #B3"
            }
            "Light" -> {
                pBgName = "White #F0"
                sBgName = "White #FF"
                pTxName = "Black"
                sTxName = "Opaque Black #8B"
            }
        }

        var name = ""
        when (type) {
            "Theme" -> name = tName
            "ThemeDark" -> name = "$tName 700"
            "Accent" -> name = aName
            "PrimaryBg" -> name = pBgName
            "SecondaryBg" -> name = sBgName
            "PrimaryText" -> name = pTxName
            "SecondaryText" -> name = sTxName
        }

        return name
    } // getColorNameAsString

    fun getRandomThemeColor(): Int {
        val rt = Themes.ThemeColor.randomThemeColor
        return switchColorToInt(rt, mResources)
    }

    fun getRandomAccentColor(): Int {
        val rt = Themes.AccentColor.randomAccentColor
        return switchColorToInt(rt, mResources)
    }

    fun getRandomColorSet(): IntArray {
        val tn = Themes.ThemeColor.randomThemeColor
        val array = ColorUtils.getColorSet("$tn - Dark", false)
        array[2] = AccentColor.getColor(Themes.ThemeColor.randomThemeColor)
        return array
    } // getRandomColorSet

    fun getRandomThemeColorSet(): IntArray {
        val themeName = Themes.ThemeColor.randomThemeColor
        return ColorUtils.getColorSet("$themeName - Dark", false)
    } // getThemeColorSet

    fun getThemeColorSet(theme: String): IntArray {
        val hue = "Dark"
        val themeName = "$theme$HUE_SPLITTER$hue"
        return ColorUtils.getColorSet(themeName, false)
    } // getThemeColorSet

} // Class
