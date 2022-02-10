package com.jb15613.themechooser.mtcpref

import com.jb15613.themechooser.utility.*
import com.jb15613.themechooser.utility.HUE_DARK
import com.jb15613.themechooser.utility.HUE_LIGHT
import com.jb15613.themechooser.utility.HUE_SPLITTER
import com.jb15613.themechooser.utility.MtcPrefException

/**
 * ## This Class will let you use a Builder to construct a theme
 *
 * ### Using the Builder ensures that your Theme String is valid
 *
 * ```
 * setTheme(new Theme.ThemeBuilder()
 *                  .themeColor(Themes.ThemeColor.getRandomThemeColor())
 *                  .accentColor(Themes.AccentColor.getRandomAccentColor())
 *                  .isLightTheme(Themes.getRandomThemeHue())
 *                  .build()
 *                  .getTheme())
 * ```
 */
class Theme(builder: ThemeBuilder) {

    private val themeColor: String
    private val accentColor: String
    private val isLightTheme: Boolean

    @get:Throws(MtcPrefException::class)
    val themeName: String
        get() = if (!themeColor.contains(" A") || !themeColor.contains("3")) {
            if (themeColor != "") {
                var theme = themeColor
                if (accentColor != "") {
                    theme += "$THEME_SPLITTER$accentColor"
                }
                theme += if (isLightTheme) {
                    "$HUE_SPLITTER$HUE_LIGHT"
                } else {
                    "$HUE_SPLITTER$HUE_DARK"
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
            return Theme(this)
        }
    }

    init {
        themeColor = builder.themeColor
        accentColor = builder.accentColor
        isLightTheme = builder.isLightTheme
    }
}