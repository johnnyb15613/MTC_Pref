package com.jb15613.themechooser.mtcpref

import com.jb15613.themechooser.utility.ColorPrefUtils
import com.jb15613.themechooser.utility.MtcPrefException
import com.jb15613.themechooser.utility.PrefUtils.setAccentColor
import com.jb15613.themechooser.utility.PrefUtils.setThemeColor
import com.jb15613.themechooser.utility.PrefUtils.setThemeHue
import com.jb15613.themechooser.utility.THEME_SPLITTER

/**
 * class Theme(builder: ThemeBuilder)
 *
 * This Class will let you use a Builder to construct a theme
 *
 * setTheme(new Theme.ThemeBuilder()
 *                  .themeColor(Themes.ThemeColor.getRandomThemeColor())
 *                  .accentColor(Themes.AccentColor.getRandomAccentColor())
 *                  .isLightTheme(Themes.getRandomThemeHue())
 *                  .build(this)
 *                  .getTheme())
 */
class Theme(builder: ThemeBuilder) {

    private val themeColor: String
    private val accentColor: String
    private val isLightTheme: Boolean

    @get:Throws(MtcPrefException::class)
    val themeName: String
        get() = if (!themeColor.contains(" A")) {
            if (themeColor != "") {
                var theme = themeColor
                if (accentColor != "") {
                    theme += " & $accentColor"
                }
                theme += if (isLightTheme) {
                    " - Light"
                } else {
                    " - Dark"
                }
                theme
            } else {
                throw MtcPrefException("ThemeColor cannot be blank")
            }
        } else {
            throw MtcPrefException("AccentColors cannot be used as ThemeColor")
        }
    val theme: Int
        get() = ThemeChooser.getTheme(themeName)

    class ThemeBuilder {

        var themeColor = ""
        var accentColor = ""
        var isLightTheme = false

        fun themeColor(themeColor: String): ThemeBuilder {
            this.themeColor = themeColor
            return this
        }

        fun accentColor(accentColor: String): ThemeBuilder {
            this.accentColor = accentColor
            return this
        }

        fun isLightTheme(isLightTheme: Boolean): ThemeBuilder {
            this.isLightTheme = isLightTheme
            return this
        }

        fun build(): Theme {
            if (accentColor == "") {
                setThemeColor(themeColor)
                ColorPrefUtils.setThemeColorsToPrefs(themeColor, "ThemeBuilder.build().noAccentColor")
            } else {
                setThemeColor(themeColor + THEME_SPLITTER.toString() + accentColor)
                ColorPrefUtils.setThemeColorsToPrefs(themeColor + THEME_SPLITTER.toString() + accentColor, "ThemeBuilder.build().withAccentColor")
            }
            setAccentColor(accentColor)
            setThemeHue(isLightTheme)
            return Theme(this)
        }
    }

    init {
        themeColor = builder.themeColor
        accentColor = builder.accentColor
        isLightTheme = builder.isLightTheme
    }
}