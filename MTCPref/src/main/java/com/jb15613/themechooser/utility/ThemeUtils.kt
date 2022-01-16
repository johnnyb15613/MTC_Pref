package com.jb15613.themechooser.utility

import com.jb15613.themechooser.mtcpref.R

internal object ThemeUtils {

    /**
     * getColoredThemeDark(themeName: [String?]): [Int]
     *
     * Retrieves Resource id of a theme
     *
     * @param themeName a [String] that is the name of the theme
     *
     * @return [Int] that is the Resource ID of the theme
     */
    fun getColoredThemeDark(themeName: String?): Int {
        var theme = 0
        when (themeName) {
            RED -> theme = R.style.AppThemeDark_Red
            PINK -> theme = R.style.AppThemeDark_Pink
            PURPLE -> theme = R.style.AppThemeDark_Purple
            DEEPPURPLE -> theme = R.style.AppThemeDark_DeepPurple
            INDIGO -> theme = R.style.AppThemeDark_Indigo
            BLUE -> theme = R.style.AppThemeDark_Blue
            LIGHTBLUE -> theme = R.style.AppThemeDark_LightBlue
            CYAN -> theme = R.style.AppThemeDark_Cyan
            TEAL -> theme = R.style.AppThemeDark_Teal
            GREEN -> theme = R.style.AppThemeDark_Green
            LIGHTGREEN -> theme = R.style.AppThemeDark_LightGreen
            LIME -> theme = R.style.AppThemeDark_Lime
            YELLOW -> theme = R.style.AppThemeDark_Yellow
            AMBER -> theme = R.style.AppThemeDark_Amber
            ORANGE -> theme = R.style.AppThemeDark_Orange
            DEEPORANGE -> theme = R.style.AppThemeDark_DeepOrange
            BROWN -> theme = R.style.AppThemeDark_Brown
            GREY -> theme = R.style.AppThemeDark_Grey
            BLUEGREY -> theme = R.style.AppThemeDark_BlueGrey
        }
        return theme
    } // getColoredThemeDark

    /**
     * getColoredThemeLight(themeName: [String?]): [Int]
     *
     * Retrieves Resource id of a theme
     *
     * @param themeName a [String] that is the name of the theme
     *
     * @return [Int] that is the Resource ID of the theme
     */
    fun getColoredThemeLight(themeName: String?): Int {
        var theme = 0
        when (themeName) {
            RED -> theme = R.style.AppThemeLight_Red
            PINK -> theme = R.style.AppThemeLight_Pink
            PURPLE -> theme = R.style.AppThemeLight_Purple
            DEEPPURPLE -> theme = R.style.AppThemeLight_DeepPurple
            INDIGO -> theme = R.style.AppThemeLight_Indigo
            BLUE -> theme = R.style.AppThemeLight_Blue
            LIGHTBLUE -> theme = R.style.AppThemeLight_LightBlue
            CYAN -> theme = R.style.AppThemeLight_Cyan
            TEAL -> theme = R.style.AppThemeLight_Teal
            GREEN -> theme = R.style.AppThemeLight_Green
            LIGHTGREEN -> theme = R.style.AppThemeLight_LightGreen
            LIME -> theme = R.style.AppThemeLight_Lime
            YELLOW -> theme = R.style.AppThemeLight_Yellow
            AMBER -> theme = R.style.AppThemeLight_Amber
            ORANGE -> theme = R.style.AppThemeLight_Orange
            DEEPORANGE -> theme = R.style.AppThemeLight_DeepOrange
            BROWN -> theme = R.style.AppThemeLight_Brown
            GREY -> theme = R.style.AppThemeLight_Grey
            BLUEGREY -> theme = R.style.AppThemeLight_BlueGrey
        }
        return theme
    } // getColoredThemeLight

} // Class