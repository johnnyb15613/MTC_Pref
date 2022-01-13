package com.jb15613.themechooser.mtcpref

import android.content.Context

import com.jb15613.themechooser.utility.MtcPrefException
import com.jb15613.themechooser.utility.PrefUtils.setAccentColor
import com.jb15613.themechooser.utility.PrefUtils.setThemeColor
import com.jb15613.themechooser.utility.PrefUtils.setThemeHue
import com.jb15613.themechooser.utility.THEME_SPLITTER


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

        fun build(c: Context): Theme {
            if (accentColor == "") {
                setThemeColor(c, themeColor)
            } else {
                setThemeColor(c, themeColor + THEME_SPLITTER.toString() + accentColor)
            }
            setAccentColor(c, accentColor)
            setThemeHue(c, isLightTheme)
            return Theme(this)
        }
    }

    init {
        themeColor = builder.themeColor
        accentColor = builder.accentColor
        isLightTheme = builder.isLightTheme
    }
}