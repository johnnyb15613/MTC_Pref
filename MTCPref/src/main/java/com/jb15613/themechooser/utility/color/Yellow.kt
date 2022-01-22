package com.jb15613.themechooser.utility.color

import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.utility.RED
import com.jb15613.themechooser.utility.RED_A1
import com.jb15613.themechooser.utility.RED_A2
import com.jb15613.themechooser.utility.RED_A4
import com.jb15613.themechooser.utility.RED_A7
import com.jb15613.themechooser.utility.PINK
import com.jb15613.themechooser.utility.PINK_A1
import com.jb15613.themechooser.utility.PINK_A2
import com.jb15613.themechooser.utility.PINK_A4
import com.jb15613.themechooser.utility.PINK_A7
import com.jb15613.themechooser.utility.PURPLE
import com.jb15613.themechooser.utility.PURPLE_A1
import com.jb15613.themechooser.utility.PURPLE_A2
import com.jb15613.themechooser.utility.PURPLE_A4
import com.jb15613.themechooser.utility.PURPLE_A7
import com.jb15613.themechooser.utility.DEEPPURPLE
import com.jb15613.themechooser.utility.DEEPPURPLE_A1
import com.jb15613.themechooser.utility.DEEPPURPLE_A2
import com.jb15613.themechooser.utility.DEEPPURPLE_A4
import com.jb15613.themechooser.utility.DEEPPURPLE_A7
import com.jb15613.themechooser.utility.INDIGO
import com.jb15613.themechooser.utility.INDIGO_A1
import com.jb15613.themechooser.utility.INDIGO_A2
import com.jb15613.themechooser.utility.INDIGO_A4
import com.jb15613.themechooser.utility.INDIGO_A7
import com.jb15613.themechooser.utility.BLUE
import com.jb15613.themechooser.utility.BLUE_A1
import com.jb15613.themechooser.utility.BLUE_A2
import com.jb15613.themechooser.utility.BLUE_A4
import com.jb15613.themechooser.utility.BLUE_A7
import com.jb15613.themechooser.utility.LIGHTBLUE
import com.jb15613.themechooser.utility.LIGHTBLUE_A1
import com.jb15613.themechooser.utility.LIGHTBLUE_A2
import com.jb15613.themechooser.utility.LIGHTBLUE_A4
import com.jb15613.themechooser.utility.LIGHTBLUE_A7
import com.jb15613.themechooser.utility.CYAN
import com.jb15613.themechooser.utility.CYAN_A1
import com.jb15613.themechooser.utility.CYAN_A2
import com.jb15613.themechooser.utility.CYAN_A4
import com.jb15613.themechooser.utility.CYAN_A7
import com.jb15613.themechooser.utility.TEAL
import com.jb15613.themechooser.utility.TEAL_A1
import com.jb15613.themechooser.utility.TEAL_A2
import com.jb15613.themechooser.utility.TEAL_A4
import com.jb15613.themechooser.utility.TEAL_A7
import com.jb15613.themechooser.utility.GREEN
import com.jb15613.themechooser.utility.GREEN_A1
import com.jb15613.themechooser.utility.GREEN_A2
import com.jb15613.themechooser.utility.GREEN_A4
import com.jb15613.themechooser.utility.GREEN_A7
import com.jb15613.themechooser.utility.LIGHTGREEN
import com.jb15613.themechooser.utility.LIGHTGREEN_A1
import com.jb15613.themechooser.utility.LIGHTGREEN_A2
import com.jb15613.themechooser.utility.LIGHTGREEN_A4
import com.jb15613.themechooser.utility.LIGHTGREEN_A7
import com.jb15613.themechooser.utility.LIME
import com.jb15613.themechooser.utility.LIME_A1
import com.jb15613.themechooser.utility.LIME_A2
import com.jb15613.themechooser.utility.LIME_A4
import com.jb15613.themechooser.utility.LIME_A7
import com.jb15613.themechooser.utility.YELLOW
import com.jb15613.themechooser.utility.YELLOW_A1
import com.jb15613.themechooser.utility.YELLOW_A2
import com.jb15613.themechooser.utility.YELLOW_A4
import com.jb15613.themechooser.utility.YELLOW_A7
import com.jb15613.themechooser.utility.AMBER
import com.jb15613.themechooser.utility.AMBER_A1
import com.jb15613.themechooser.utility.AMBER_A2
import com.jb15613.themechooser.utility.AMBER_A4
import com.jb15613.themechooser.utility.AMBER_A7
import com.jb15613.themechooser.utility.ORANGE
import com.jb15613.themechooser.utility.ORANGE_A1
import com.jb15613.themechooser.utility.ORANGE_A2
import com.jb15613.themechooser.utility.ORANGE_A4
import com.jb15613.themechooser.utility.ORANGE_A7
import com.jb15613.themechooser.utility.DEEPORANGE
import com.jb15613.themechooser.utility.DEEPORANGE_A1
import com.jb15613.themechooser.utility.DEEPORANGE_A2
import com.jb15613.themechooser.utility.DEEPORANGE_A4
import com.jb15613.themechooser.utility.DEEPORANGE_A7
import com.jb15613.themechooser.utility.BROWN
import com.jb15613.themechooser.utility.BROWN_3
import com.jb15613.themechooser.utility.GREY
import com.jb15613.themechooser.utility.GREY_3
import com.jb15613.themechooser.utility.BLUEGREY
import com.jb15613.themechooser.utility.BLUEGREY_3

/**
## Utilities for Retrieving *Yellow* Themes
 */
internal class Yellow {

    /**
     ## This method gets dark version of theme
     *
     * @param themeName a [String] containing the Theme Name
     *
     * @return [Int] the Resource Id of the Theme
     */
    fun getThemeDark(themeName: String) : Int {

        var theme = 0

        when (themeName) {
            RED -> theme = R.style.AppThemeDark_Yellow_Red
            RED_A1 -> theme = R.style.AppThemeDark_Yellow_RedA1
            RED_A2 -> theme = R.style.AppThemeDark_Yellow_RedA2
            RED_A4 -> theme = R.style.AppThemeDark_Yellow_RedA4
            RED_A7 -> theme = R.style.AppThemeDark_Yellow_RedA7

            PINK -> theme = R.style.AppThemeDark_Yellow_Pink
            PINK_A1 -> theme = R.style.AppThemeDark_Yellow_PinkA1
            PINK_A2 -> theme = R.style.AppThemeDark_Yellow_PinkA2
            PINK_A4 -> theme = R.style.AppThemeDark_Yellow_PinkA4
            PINK_A7 -> theme = R.style.AppThemeDark_Yellow_PinkA7

            PURPLE -> theme = R.style.AppThemeDark_Yellow_Purple
            PURPLE_A1 -> theme = R.style.AppThemeDark_Yellow_PurpleA1
            PURPLE_A2 -> theme = R.style.AppThemeDark_Yellow_PurpleA2
            PURPLE_A4 -> theme = R.style.AppThemeDark_Yellow_PurpleA4
            PURPLE_A7 -> theme = R.style.AppThemeDark_Yellow_PurpleA7

            DEEPPURPLE -> theme = R.style.AppThemeDark_Yellow_DeepPurple
            DEEPPURPLE_A1 -> theme = R.style.AppThemeDark_Yellow_DeepPurpleA1
            DEEPPURPLE_A2 -> theme = R.style.AppThemeDark_Yellow_DeepPurpleA2
            DEEPPURPLE_A4 -> theme = R.style.AppThemeDark_Yellow_DeepPurpleA4
            DEEPPURPLE_A7 -> theme = R.style.AppThemeDark_Yellow_DeepPurpleA7

            INDIGO -> theme = R.style.AppThemeDark_Yellow_Indigo
            INDIGO_A1 -> theme = R.style.AppThemeDark_Yellow_IndigoA1
            INDIGO_A2 -> theme = R.style.AppThemeDark_Yellow_IndigoA2
            INDIGO_A4 -> theme = R.style.AppThemeDark_Yellow_IndigoA4
            INDIGO_A7 -> theme = R.style.AppThemeDark_Yellow_IndigoA7

            BLUE -> theme = R.style.AppThemeDark_Yellow_Blue
            BLUE_A1 -> theme = R.style.AppThemeDark_Yellow_BlueA1
            BLUE_A2 -> theme = R.style.AppThemeDark_Yellow_BlueA2
            BLUE_A4 -> theme = R.style.AppThemeDark_Yellow_BlueA4
            BLUE_A7 -> theme = R.style.AppThemeDark_Yellow_BlueA7

            LIGHTBLUE -> theme = R.style.AppThemeDark_Yellow_LightBlue
            LIGHTBLUE_A1 -> theme = R.style.AppThemeDark_Yellow_LightBlueA1
            LIGHTBLUE_A2 -> theme = R.style.AppThemeDark_Yellow_LightBlueA2
            LIGHTBLUE_A4 -> theme = R.style.AppThemeDark_Yellow_LightBlueA4
            LIGHTBLUE_A7 -> theme = R.style.AppThemeDark_Yellow_LightBlueA7

            CYAN -> theme = R.style.AppThemeDark_Yellow_Cyan
            CYAN_A1 -> theme = R.style.AppThemeDark_Yellow_CyanA1
            CYAN_A2 -> theme = R.style.AppThemeDark_Yellow_CyanA2
            CYAN_A4 -> theme = R.style.AppThemeDark_Yellow_CyanA4
            CYAN_A7 -> theme = R.style.AppThemeDark_Yellow_CyanA7

            TEAL -> theme = R.style.AppThemeDark_Yellow_Teal
            TEAL_A1 -> theme = R.style.AppThemeDark_Yellow_TealA1
            TEAL_A2 -> theme = R.style.AppThemeDark_Yellow_TealA2
            TEAL_A4 -> theme = R.style.AppThemeDark_Yellow_TealA4
            TEAL_A7 -> theme = R.style.AppThemeDark_Yellow_TealA7

            GREEN -> theme = R.style.AppThemeDark_Yellow_Green
            GREEN_A1 -> theme = R.style.AppThemeDark_Yellow_GreenA1
            GREEN_A2 -> theme = R.style.AppThemeDark_Yellow_GreenA2
            GREEN_A4 -> theme = R.style.AppThemeDark_Yellow_GreenA4
            GREEN_A7 -> theme = R.style.AppThemeDark_Yellow_GreenA7

            LIGHTGREEN -> theme = R.style.AppThemeDark_Yellow_LightGreen
            LIGHTGREEN_A1 -> theme = R.style.AppThemeDark_Yellow_LightGreenA1
            LIGHTGREEN_A2 -> theme = R.style.AppThemeDark_Yellow_LightGreenA2
            LIGHTGREEN_A4 -> theme = R.style.AppThemeDark_Yellow_LightGreenA4
            LIGHTGREEN_A7 -> theme = R.style.AppThemeDark_Yellow_LightGreenA7

            LIME -> theme = R.style.AppThemeDark_Yellow_Lime
            LIME_A1 -> theme = R.style.AppThemeDark_Yellow_LimeA1
            LIME_A2 -> theme = R.style.AppThemeDark_Yellow_LimeA2
            LIME_A4 -> theme = R.style.AppThemeDark_Yellow_LimeA4
            LIME_A7 -> theme = R.style.AppThemeDark_Yellow_LimeA7

            YELLOW -> theme = R.style.AppThemeDark_Yellow_Yellow
            YELLOW_A1 -> theme = R.style.AppThemeDark_Yellow_YellowA1
            YELLOW_A2 -> theme = R.style.AppThemeDark_Yellow_YellowA2
            YELLOW_A4 -> theme = R.style.AppThemeDark_Yellow_YellowA4
            YELLOW_A7 -> theme = R.style.AppThemeDark_Yellow_YellowA7

            AMBER -> theme = R.style.AppThemeDark_Yellow_Amber
            AMBER_A1 -> theme = R.style.AppThemeDark_Yellow_AmberA1
            AMBER_A2 -> theme = R.style.AppThemeDark_Yellow_AmberA2
            AMBER_A4 -> theme = R.style.AppThemeDark_Yellow_AmberA4
            AMBER_A7 -> theme = R.style.AppThemeDark_Yellow_AmberA7

            ORANGE -> theme = R.style.AppThemeDark_Yellow_Orange
            ORANGE_A1 -> theme = R.style.AppThemeDark_Yellow_OrangeA1
            ORANGE_A2 -> theme = R.style.AppThemeDark_Yellow_OrangeA2
            ORANGE_A4 -> theme = R.style.AppThemeDark_Yellow_OrangeA4
            ORANGE_A7 -> theme = R.style.AppThemeDark_Yellow_OrangeA7

            DEEPORANGE -> theme = R.style.AppThemeDark_Yellow_DeepOrange
            DEEPORANGE_A1 -> theme = R.style.AppThemeDark_Yellow_DeepOrangeA1
            DEEPORANGE_A2 -> theme = R.style.AppThemeDark_Yellow_DeepOrangeA2
            DEEPORANGE_A4 -> theme = R.style.AppThemeDark_Yellow_DeepOrangeA4
            DEEPORANGE_A7 -> theme = R.style.AppThemeDark_Yellow_DeepOrangeA7

            BROWN -> theme = R.style.AppThemeDark_Yellow_Brown
            BROWN_3 -> theme = R.style.AppThemeDark_Yellow_Brown3

            GREY -> theme = R.style.AppThemeDark_Yellow_Grey
            GREY_3 -> theme = R.style.AppThemeDark_Yellow_Grey3

            BLUEGREY -> theme = R.style.AppThemeDark_Yellow_BlueGrey
            BLUEGREY_3 -> theme = R.style.AppThemeDark_Yellow_BlueGrey3
        }

        return theme

    } // getThemeDark()

    /**
    ## This method gets light version of theme
     *
     * @param themeName a [String] containing the Theme Name
     *
     * @return [Int] the Resource Id of the Theme
     */
    fun getThemeLight(themeName: String) : Int {

        var theme = 0

        when (themeName) {
            RED -> theme = R.style.AppThemeLight_Yellow_Red
            RED_A1 -> theme = R.style.AppThemeLight_Yellow_RedA1
            RED_A2 -> theme = R.style.AppThemeLight_Yellow_RedA2
            RED_A4 -> theme = R.style.AppThemeLight_Yellow_RedA4
            RED_A7 -> theme = R.style.AppThemeLight_Yellow_RedA7

            PINK -> theme = R.style.AppThemeLight_Yellow_Pink
            PINK_A1 -> theme = R.style.AppThemeLight_Yellow_PinkA1
            PINK_A2 -> theme = R.style.AppThemeLight_Yellow_PinkA2
            PINK_A4 -> theme = R.style.AppThemeLight_Yellow_PinkA4
            PINK_A7 -> theme = R.style.AppThemeLight_Yellow_PinkA7

            PURPLE -> theme = R.style.AppThemeLight_Yellow_Purple
            PURPLE_A1 -> theme = R.style.AppThemeLight_Yellow_PurpleA1
            PURPLE_A2 -> theme = R.style.AppThemeLight_Yellow_PurpleA2
            PURPLE_A4 -> theme = R.style.AppThemeLight_Yellow_PurpleA4
            PURPLE_A7 -> theme = R.style.AppThemeLight_Yellow_PurpleA7

            DEEPPURPLE -> theme = R.style.AppThemeLight_Yellow_DeepPurple
            DEEPPURPLE_A1 -> theme = R.style.AppThemeLight_Yellow_DeepPurpleA1
            DEEPPURPLE_A2 -> theme = R.style.AppThemeLight_Yellow_DeepPurpleA2
            DEEPPURPLE_A4 -> theme = R.style.AppThemeLight_Yellow_DeepPurpleA4
            DEEPPURPLE_A7 -> theme = R.style.AppThemeLight_Yellow_DeepPurpleA7

            INDIGO -> theme = R.style.AppThemeLight_Yellow_Indigo
            INDIGO_A1 -> theme = R.style.AppThemeLight_Yellow_IndigoA1
            INDIGO_A2 -> theme = R.style.AppThemeLight_Yellow_IndigoA2
            INDIGO_A4 -> theme = R.style.AppThemeLight_Yellow_IndigoA4
            INDIGO_A7 -> theme = R.style.AppThemeLight_Yellow_IndigoA7

            BLUE -> theme = R.style.AppThemeLight_Yellow_Blue
            BLUE_A1 -> theme = R.style.AppThemeLight_Yellow_BlueA1
            BLUE_A2 -> theme = R.style.AppThemeLight_Yellow_BlueA2
            BLUE_A4 -> theme = R.style.AppThemeLight_Yellow_BlueA4
            BLUE_A7 -> theme = R.style.AppThemeLight_Yellow_BlueA7

            LIGHTBLUE -> theme = R.style.AppThemeLight_Yellow_LightBlue
            LIGHTBLUE_A1 -> theme = R.style.AppThemeLight_Yellow_LightBlueA1
            LIGHTBLUE_A2 -> theme = R.style.AppThemeLight_Yellow_LightBlueA2
            LIGHTBLUE_A4 -> theme = R.style.AppThemeLight_Yellow_LightBlueA4
            LIGHTBLUE_A7 -> theme = R.style.AppThemeLight_Yellow_LightBlueA7

            CYAN -> theme = R.style.AppThemeLight_Yellow_Cyan
            CYAN_A1 -> theme = R.style.AppThemeLight_Yellow_CyanA1
            CYAN_A2 -> theme = R.style.AppThemeLight_Yellow_CyanA2
            CYAN_A4 -> theme = R.style.AppThemeLight_Yellow_CyanA4
            CYAN_A7 -> theme = R.style.AppThemeLight_Yellow_CyanA7

            TEAL -> theme = R.style.AppThemeLight_Yellow_Teal
            TEAL_A1 -> theme = R.style.AppThemeLight_Yellow_TealA1
            TEAL_A2 -> theme = R.style.AppThemeLight_Yellow_TealA2
            TEAL_A4 -> theme = R.style.AppThemeLight_Yellow_TealA4
            TEAL_A7 -> theme = R.style.AppThemeLight_Yellow_TealA7

            GREEN -> theme = R.style.AppThemeLight_Yellow_Green
            GREEN_A1 -> theme = R.style.AppThemeLight_Yellow_GreenA1
            GREEN_A2 -> theme = R.style.AppThemeLight_Yellow_GreenA2
            GREEN_A4 -> theme = R.style.AppThemeLight_Yellow_GreenA4
            GREEN_A7 -> theme = R.style.AppThemeLight_Yellow_GreenA7

            LIGHTGREEN -> theme = R.style.AppThemeLight_Yellow_LightGreen
            LIGHTGREEN_A1 -> theme = R.style.AppThemeLight_Yellow_LightGreenA1
            LIGHTGREEN_A2 -> theme = R.style.AppThemeLight_Yellow_LightGreenA2
            LIGHTGREEN_A4 -> theme = R.style.AppThemeLight_Yellow_LightGreenA4
            LIGHTGREEN_A7 -> theme = R.style.AppThemeLight_Yellow_LightGreenA7

            LIME -> theme = R.style.AppThemeLight_Yellow_Lime
            LIME_A1 -> theme = R.style.AppThemeLight_Yellow_LimeA1
            LIME_A2 -> theme = R.style.AppThemeLight_Yellow_LimeA2
            LIME_A4 -> theme = R.style.AppThemeLight_Yellow_LimeA4
            LIME_A7 -> theme = R.style.AppThemeLight_Yellow_LimeA7

            YELLOW -> theme = R.style.AppThemeLight_Yellow_Yellow
            YELLOW_A1 -> theme = R.style.AppThemeLight_Yellow_YellowA1
            YELLOW_A2 -> theme = R.style.AppThemeLight_Yellow_YellowA2
            YELLOW_A4 -> theme = R.style.AppThemeLight_Yellow_YellowA4
            YELLOW_A7 -> theme = R.style.AppThemeLight_Yellow_YellowA7

            AMBER -> theme = R.style.AppThemeLight_Yellow_Amber
            AMBER_A1 -> theme = R.style.AppThemeLight_Yellow_AmberA1
            AMBER_A2 -> theme = R.style.AppThemeLight_Yellow_AmberA2
            AMBER_A4 -> theme = R.style.AppThemeLight_Yellow_AmberA4
            AMBER_A7 -> theme = R.style.AppThemeLight_Yellow_AmberA7

            ORANGE -> theme = R.style.AppThemeLight_Yellow_Orange
            ORANGE_A1 -> theme = R.style.AppThemeLight_Yellow_OrangeA1
            ORANGE_A2 -> theme = R.style.AppThemeLight_Yellow_OrangeA2
            ORANGE_A4 -> theme = R.style.AppThemeLight_Yellow_OrangeA4
            ORANGE_A7 -> theme = R.style.AppThemeLight_Yellow_OrangeA7

            DEEPORANGE -> theme = R.style.AppThemeLight_Yellow_DeepOrange
            DEEPORANGE_A1 -> theme = R.style.AppThemeLight_Yellow_DeepOrangeA1
            DEEPORANGE_A2 -> theme = R.style.AppThemeLight_Yellow_DeepOrangeA2
            DEEPORANGE_A4 -> theme = R.style.AppThemeLight_Yellow_DeepOrangeA4
            DEEPORANGE_A7 -> theme = R.style.AppThemeLight_Yellow_DeepOrangeA7

            BROWN -> theme = R.style.AppThemeLight_Yellow_Brown
            BROWN_3 -> theme = R.style.AppThemeLight_Yellow_Brown3

            GREY -> theme = R.style.AppThemeLight_Yellow_Grey
            GREY_3 -> theme = R.style.AppThemeLight_Yellow_Grey3

            BLUEGREY -> theme = R.style.AppThemeLight_Yellow_BlueGrey
            BLUEGREY_3 -> theme = R.style.AppThemeLight_Yellow_BlueGrey3
        }

        return theme

    } // getThemeLight()

} // Class