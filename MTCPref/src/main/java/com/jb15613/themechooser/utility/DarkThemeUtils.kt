package com.jb15613.themechooser.utility

import com.jb15613.themechooser.utility.color.*

/**
## Utilities for Retrieving Light Themes
 */
internal object DarkThemeUtils {

    /**
     ## Retrieves Resource ID of a theme
     *
     * @param  themeName a [String] that is the name of the Theme
     *
     * @return  [Int] that is the Resource ID of the theme
     */
    fun getCustomColoredDarkTheme(themeName: String): Int {
        var theme = 0

        val items: List<String> = themeName.split(THEME_SPLITTER)

        when (items[0]) {
            RED -> theme = Red().getThemeDark(items[1])
            PINK -> theme = Pink().getThemeDark(items[1])
            PURPLE -> theme = Purple().getThemeDark(items[1])
            DEEPPURPLE -> theme = DeepPurple().getThemeDark(items[1])
            INDIGO -> theme = Indigo().getThemeDark(items[1])
            BLUE -> theme = Blue().getThemeDark(items[1])
            LIGHTBLUE -> theme = LightBlue().getThemeDark(items[1])
            CYAN -> theme = Cyan().getThemeDark(items[1])
            TEAL -> theme = Teal().getThemeDark(items[1])
            GREEN -> theme = Green().getThemeDark(items[1])
            LIGHTGREEN -> theme = LightGreen().getThemeDark(items[1])
            LIME -> theme = Lime().getThemeDark(items[1])
            YELLOW -> theme = Yellow().getThemeDark(items[1])
            AMBER -> theme = Amber().getThemeDark(items[1])
            ORANGE -> theme = Orange().getThemeDark(items[1])
            DEEPORANGE -> theme = DeepOrange().getThemeDark(items[1])
            BROWN -> theme = Brown().getThemeDark(items[1])
            GREY -> theme = Grey().getThemeDark(items[1])
            BLUEGREY -> theme = BlueGrey().getThemeDark(items[1])
        }

        return theme
    }

}