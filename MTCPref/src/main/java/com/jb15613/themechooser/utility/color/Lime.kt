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
## Utilities for Retrieving *Lime* Themes
 */
internal class Lime {

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
            RED -> theme = R.style.AppThemeDark_Lime_Red
            RED_A1 -> theme = R.style.AppThemeDark_Lime_RedA1
            RED_A2 -> theme = R.style.AppThemeDark_Lime_RedA2
            RED_A4 -> theme = R.style.AppThemeDark_Lime_RedA4
            RED_A7 -> theme = R.style.AppThemeDark_Lime_RedA7

            PINK -> theme = R.style.AppThemeDark_Lime_Pink
            PINK_A1 -> theme = R.style.AppThemeDark_Lime_PinkA1
            PINK_A2 -> theme = R.style.AppThemeDark_Lime_PinkA2
            PINK_A4 -> theme = R.style.AppThemeDark_Lime_PinkA4
            PINK_A7 -> theme = R.style.AppThemeDark_Lime_PinkA7

            PURPLE -> theme = R.style.AppThemeDark_Lime_Purple
            PURPLE_A1 -> theme = R.style.AppThemeDark_Lime_PurpleA1
            PURPLE_A2 -> theme = R.style.AppThemeDark_Lime_PurpleA2
            PURPLE_A4 -> theme = R.style.AppThemeDark_Lime_PurpleA4
            PURPLE_A7 -> theme = R.style.AppThemeDark_Lime_PurpleA7

            DEEPPURPLE -> theme = R.style.AppThemeDark_Lime_DeepPurple
            DEEPPURPLE_A1 -> theme = R.style.AppThemeDark_Lime_DeepPurpleA1
            DEEPPURPLE_A2 -> theme = R.style.AppThemeDark_Lime_DeepPurpleA2
            DEEPPURPLE_A4 -> theme = R.style.AppThemeDark_Lime_DeepPurpleA4
            DEEPPURPLE_A7 -> theme = R.style.AppThemeDark_Lime_DeepPurpleA7

            INDIGO -> theme = R.style.AppThemeDark_Lime_Indigo
            INDIGO_A1 -> theme = R.style.AppThemeDark_Lime_IndigoA1
            INDIGO_A2 -> theme = R.style.AppThemeDark_Lime_IndigoA2
            INDIGO_A4 -> theme = R.style.AppThemeDark_Lime_IndigoA4
            INDIGO_A7 -> theme = R.style.AppThemeDark_Lime_IndigoA7

            BLUE -> theme = R.style.AppThemeDark_Lime_Blue
            BLUE_A1 -> theme = R.style.AppThemeDark_Lime_BlueA1
            BLUE_A2 -> theme = R.style.AppThemeDark_Lime_BlueA2
            BLUE_A4 -> theme = R.style.AppThemeDark_Lime_BlueA4
            BLUE_A7 -> theme = R.style.AppThemeDark_Lime_BlueA7

            LIGHTBLUE -> theme = R.style.AppThemeDark_Lime_LightBlue
            LIGHTBLUE_A1 -> theme = R.style.AppThemeDark_Lime_LightBlueA1
            LIGHTBLUE_A2 -> theme = R.style.AppThemeDark_Lime_LightBlueA2
            LIGHTBLUE_A4 -> theme = R.style.AppThemeDark_Lime_LightBlueA4
            LIGHTBLUE_A7 -> theme = R.style.AppThemeDark_Lime_LightBlueA7

            CYAN -> theme = R.style.AppThemeDark_Lime_Cyan
            CYAN_A1 -> theme = R.style.AppThemeDark_Lime_CyanA1
            CYAN_A2 -> theme = R.style.AppThemeDark_Lime_CyanA2
            CYAN_A4 -> theme = R.style.AppThemeDark_Lime_CyanA4
            CYAN_A7 -> theme = R.style.AppThemeDark_Lime_CyanA7

            TEAL -> theme = R.style.AppThemeDark_Lime_Teal
            TEAL_A1 -> theme = R.style.AppThemeDark_Lime_TealA1
            TEAL_A2 -> theme = R.style.AppThemeDark_Lime_TealA2
            TEAL_A4 -> theme = R.style.AppThemeDark_Lime_TealA4
            TEAL_A7 -> theme = R.style.AppThemeDark_Lime_TealA7

            GREEN -> theme = R.style.AppThemeDark_Lime_Green
            GREEN_A1 -> theme = R.style.AppThemeDark_Lime_GreenA1
            GREEN_A2 -> theme = R.style.AppThemeDark_Lime_GreenA2
            GREEN_A4 -> theme = R.style.AppThemeDark_Lime_GreenA4
            GREEN_A7 -> theme = R.style.AppThemeDark_Lime_GreenA7

            LIGHTGREEN -> theme = R.style.AppThemeDark_Lime_LightGreen
            LIGHTGREEN_A1 -> theme = R.style.AppThemeDark_Lime_LightGreenA1
            LIGHTGREEN_A2 -> theme = R.style.AppThemeDark_Lime_LightGreenA2
            LIGHTGREEN_A4 -> theme = R.style.AppThemeDark_Lime_LightGreenA4
            LIGHTGREEN_A7 -> theme = R.style.AppThemeDark_Lime_LightGreenA7

            LIME -> theme = R.style.AppThemeDark_Lime_Lime
            LIME_A1 -> theme = R.style.AppThemeDark_Lime_LimeA1
            LIME_A2 -> theme = R.style.AppThemeDark_Lime_LimeA2
            LIME_A4 -> theme = R.style.AppThemeDark_Lime_LimeA4
            LIME_A7 -> theme = R.style.AppThemeDark_Lime_LimeA7

            YELLOW -> theme = R.style.AppThemeDark_Lime_Yellow
            YELLOW_A1 -> theme = R.style.AppThemeDark_Lime_YellowA1
            YELLOW_A2 -> theme = R.style.AppThemeDark_Lime_YellowA2
            YELLOW_A4 -> theme = R.style.AppThemeDark_Lime_YellowA4
            YELLOW_A7 -> theme = R.style.AppThemeDark_Lime_YellowA7

            AMBER -> theme = R.style.AppThemeDark_Lime_Amber
            AMBER_A1 -> theme = R.style.AppThemeDark_Lime_AmberA1
            AMBER_A2 -> theme = R.style.AppThemeDark_Lime_AmberA2
            AMBER_A4 -> theme = R.style.AppThemeDark_Lime_AmberA4
            AMBER_A7 -> theme = R.style.AppThemeDark_Lime_AmberA7

            ORANGE -> theme = R.style.AppThemeDark_Lime_Orange
            ORANGE_A1 -> theme = R.style.AppThemeDark_Lime_OrangeA1
            ORANGE_A2 -> theme = R.style.AppThemeDark_Lime_OrangeA2
            ORANGE_A4 -> theme = R.style.AppThemeDark_Lime_OrangeA4
            ORANGE_A7 -> theme = R.style.AppThemeDark_Lime_OrangeA7

            DEEPORANGE -> theme = R.style.AppThemeDark_Lime_DeepOrange
            DEEPORANGE_A1 -> theme = R.style.AppThemeDark_Lime_DeepOrangeA1
            DEEPORANGE_A2 -> theme = R.style.AppThemeDark_Lime_DeepOrangeA2
            DEEPORANGE_A4 -> theme = R.style.AppThemeDark_Lime_DeepOrangeA4
            DEEPORANGE_A7 -> theme = R.style.AppThemeDark_Lime_DeepOrangeA7

            BROWN -> theme = R.style.AppThemeDark_Lime_Brown
            BROWN_3 -> theme = R.style.AppThemeDark_Lime_Brown3

            GREY -> theme = R.style.AppThemeDark_Lime_Grey
            GREY_3 -> theme = R.style.AppThemeDark_Lime_Grey3

            BLUEGREY -> theme = R.style.AppThemeDark_Lime_BlueGrey
            BLUEGREY_3 -> theme = R.style.AppThemeDark_Lime_BlueGrey3
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
            RED -> theme = R.style.AppThemeLight_Lime_Red
            RED_A1 -> theme = R.style.AppThemeLight_Lime_RedA1
            RED_A2 -> theme = R.style.AppThemeLight_Lime_RedA2
            RED_A4 -> theme = R.style.AppThemeLight_Lime_RedA4
            RED_A7 -> theme = R.style.AppThemeLight_Lime_RedA7

            PINK -> theme = R.style.AppThemeLight_Lime_Pink
            PINK_A1 -> theme = R.style.AppThemeLight_Lime_PinkA1
            PINK_A2 -> theme = R.style.AppThemeLight_Lime_PinkA2
            PINK_A4 -> theme = R.style.AppThemeLight_Lime_PinkA4
            PINK_A7 -> theme = R.style.AppThemeLight_Lime_PinkA7

            PURPLE -> theme = R.style.AppThemeLight_Lime_Purple
            PURPLE_A1 -> theme = R.style.AppThemeLight_Lime_PurpleA1
            PURPLE_A2 -> theme = R.style.AppThemeLight_Lime_PurpleA2
            PURPLE_A4 -> theme = R.style.AppThemeLight_Lime_PurpleA4
            PURPLE_A7 -> theme = R.style.AppThemeLight_Lime_PurpleA7

            DEEPPURPLE -> theme = R.style.AppThemeLight_Lime_DeepPurple
            DEEPPURPLE_A1 -> theme = R.style.AppThemeLight_Lime_DeepPurpleA1
            DEEPPURPLE_A2 -> theme = R.style.AppThemeLight_Lime_DeepPurpleA2
            DEEPPURPLE_A4 -> theme = R.style.AppThemeLight_Lime_DeepPurpleA4
            DEEPPURPLE_A7 -> theme = R.style.AppThemeLight_Lime_DeepPurpleA7

            INDIGO -> theme = R.style.AppThemeLight_Lime_Indigo
            INDIGO_A1 -> theme = R.style.AppThemeLight_Lime_IndigoA1
            INDIGO_A2 -> theme = R.style.AppThemeLight_Lime_IndigoA2
            INDIGO_A4 -> theme = R.style.AppThemeLight_Lime_IndigoA4
            INDIGO_A7 -> theme = R.style.AppThemeLight_Lime_IndigoA7

            BLUE -> theme = R.style.AppThemeLight_Lime_Blue
            BLUE_A1 -> theme = R.style.AppThemeLight_Lime_BlueA1
            BLUE_A2 -> theme = R.style.AppThemeLight_Lime_BlueA2
            BLUE_A4 -> theme = R.style.AppThemeLight_Lime_BlueA4
            BLUE_A7 -> theme = R.style.AppThemeLight_Lime_BlueA7

            LIGHTBLUE -> theme = R.style.AppThemeLight_Lime_LightBlue
            LIGHTBLUE_A1 -> theme = R.style.AppThemeLight_Lime_LightBlueA1
            LIGHTBLUE_A2 -> theme = R.style.AppThemeLight_Lime_LightBlueA2
            LIGHTBLUE_A4 -> theme = R.style.AppThemeLight_Lime_LightBlueA4
            LIGHTBLUE_A7 -> theme = R.style.AppThemeLight_Lime_LightBlueA7

            CYAN -> theme = R.style.AppThemeLight_Lime_Cyan
            CYAN_A1 -> theme = R.style.AppThemeLight_Lime_CyanA1
            CYAN_A2 -> theme = R.style.AppThemeLight_Lime_CyanA2
            CYAN_A4 -> theme = R.style.AppThemeLight_Lime_CyanA4
            CYAN_A7 -> theme = R.style.AppThemeLight_Lime_CyanA7

            TEAL -> theme = R.style.AppThemeLight_Lime_Teal
            TEAL_A1 -> theme = R.style.AppThemeLight_Lime_TealA1
            TEAL_A2 -> theme = R.style.AppThemeLight_Lime_TealA2
            TEAL_A4 -> theme = R.style.AppThemeLight_Lime_TealA4
            TEAL_A7 -> theme = R.style.AppThemeLight_Lime_TealA7

            GREEN -> theme = R.style.AppThemeLight_Lime_Green
            GREEN_A1 -> theme = R.style.AppThemeLight_Lime_GreenA1
            GREEN_A2 -> theme = R.style.AppThemeLight_Lime_GreenA2
            GREEN_A4 -> theme = R.style.AppThemeLight_Lime_GreenA4
            GREEN_A7 -> theme = R.style.AppThemeLight_Lime_GreenA7

            LIGHTGREEN -> theme = R.style.AppThemeLight_Lime_LightGreen
            LIGHTGREEN_A1 -> theme = R.style.AppThemeLight_Lime_LightGreenA1
            LIGHTGREEN_A2 -> theme = R.style.AppThemeLight_Lime_LightGreenA2
            LIGHTGREEN_A4 -> theme = R.style.AppThemeLight_Lime_LightGreenA4
            LIGHTGREEN_A7 -> theme = R.style.AppThemeLight_Lime_LightGreenA7

            LIME -> theme = R.style.AppThemeLight_Lime_Lime
            LIME_A1 -> theme = R.style.AppThemeLight_Lime_LimeA1
            LIME_A2 -> theme = R.style.AppThemeLight_Lime_LimeA2
            LIME_A4 -> theme = R.style.AppThemeLight_Lime_LimeA4
            LIME_A7 -> theme = R.style.AppThemeLight_Lime_LimeA7

            YELLOW -> theme = R.style.AppThemeLight_Lime_Yellow
            YELLOW_A1 -> theme = R.style.AppThemeLight_Lime_YellowA1
            YELLOW_A2 -> theme = R.style.AppThemeLight_Lime_YellowA2
            YELLOW_A4 -> theme = R.style.AppThemeLight_Lime_YellowA4
            YELLOW_A7 -> theme = R.style.AppThemeLight_Lime_YellowA7

            AMBER -> theme = R.style.AppThemeLight_Lime_Amber
            AMBER_A1 -> theme = R.style.AppThemeLight_Lime_AmberA1
            AMBER_A2 -> theme = R.style.AppThemeLight_Lime_AmberA2
            AMBER_A4 -> theme = R.style.AppThemeLight_Lime_AmberA4
            AMBER_A7 -> theme = R.style.AppThemeLight_Lime_AmberA7

            ORANGE -> theme = R.style.AppThemeLight_Lime_Orange
            ORANGE_A1 -> theme = R.style.AppThemeLight_Lime_OrangeA1
            ORANGE_A2 -> theme = R.style.AppThemeLight_Lime_OrangeA2
            ORANGE_A4 -> theme = R.style.AppThemeLight_Lime_OrangeA4
            ORANGE_A7 -> theme = R.style.AppThemeLight_Lime_OrangeA7

            DEEPORANGE -> theme = R.style.AppThemeLight_Lime_DeepOrange
            DEEPORANGE_A1 -> theme = R.style.AppThemeLight_Lime_DeepOrangeA1
            DEEPORANGE_A2 -> theme = R.style.AppThemeLight_Lime_DeepOrangeA2
            DEEPORANGE_A4 -> theme = R.style.AppThemeLight_Lime_DeepOrangeA4
            DEEPORANGE_A7 -> theme = R.style.AppThemeLight_Lime_DeepOrangeA7

            BROWN -> theme = R.style.AppThemeLight_Lime_Brown
            BROWN_3 -> theme = R.style.AppThemeLight_Lime_Brown3

            GREY -> theme = R.style.AppThemeLight_Lime_Grey
            GREY_3 -> theme = R.style.AppThemeLight_Lime_Grey3

            BLUEGREY -> theme = R.style.AppThemeLight_Lime_BlueGrey
            BLUEGREY_3 -> theme = R.style.AppThemeLight_Lime_BlueGrey3
        }

        return theme

    } // getThemeLight()

} // Class