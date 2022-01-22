package com.jb15613.themechooser.utility

import com.jb15613.themechooser.utility.color.*

/**
## Utilities for Retrieving Light Themes
 */
internal object LightThemeUtils {

    /**
     ## Retrieves Resource ID of a theme
     *
     * @param  themeName a [String] that is the name of the Theme
     *
     * @return  [Int] that is the Resource ID of the theme
     */
    fun getCustomColoredLightTheme(themeName: String): Int {
        var theme = 0

        val items: List<String> = themeName.split(THEME_SPLITTER)

        when (items[0]) {
            RED -> theme = Red().getThemeLight(items[1])
            PINK -> theme = Pink().getThemeLight(items[1])
            PURPLE -> theme = Purple().getThemeLight(items[1])
            DEEPPURPLE -> theme = DeepPurple().getThemeLight(items[1])
            INDIGO -> theme = Indigo().getThemeLight(items[1])
            BLUE -> theme = Blue().getThemeLight(items[1])
            LIGHTBLUE -> theme = LightBlue().getThemeLight(items[1])
            CYAN -> theme = Cyan().getThemeLight(items[1])
            TEAL -> theme = Teal().getThemeLight(items[1])
            GREEN -> theme = Green().getThemeLight(items[1])
            LIGHTGREEN -> theme = LightGreen().getThemeLight(items[1])
            LIME -> theme = Lime().getThemeLight(items[1])
            YELLOW -> theme = Yellow().getThemeLight(items[1])
            AMBER -> theme = Amber().getThemeLight(items[1])
            ORANGE -> theme = Orange().getThemeLight(items[1])
            DEEPORANGE -> theme = DeepOrange().getThemeLight(items[1])
            BROWN -> theme = Brown().getThemeLight(items[1])
            GREY -> theme = Grey().getThemeLight(items[1])
            BLUEGREY -> theme = BlueGrey().getThemeLight(items[1])
        }

        return theme
    }

}