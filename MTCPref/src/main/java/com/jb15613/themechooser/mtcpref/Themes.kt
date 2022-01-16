package com.jb15613.themechooser.mtcpref

import com.jb15613.themechooser.utility.*
import java.util.*

object Themes {

    /**
     * randomThemeHue: [Boolean]
     *
     * Gets a random ThemeHue
     *
     * @return [Boolean] (false = Dark : true = Light)
     */
    val randomThemeHue: Boolean
        get() = Math.random() < 0.5

    object ThemeColor {
        // Red
        const val Red: String = RED

        // Pink
        const val Pink: String = PINK

        // Purple
        const val Purple: String = PURPLE

        // DeepPurple
        const val DeepPurple: String = DEEPPURPLE

        // Indigo
        const val Indigo: String = INDIGO

        // Blue
        const val Blue: String = BLUE

        // LightBlue
        const val LightBlue: String = LIGHTBLUE

        // Cyan
        const val Cyan: String = CYAN

        // Teal
        const val Teal: String = TEAL

        // Green
        const val Green: String = GREEN

        // LightGreen
        const val LightGreen: String = LIGHTGREEN

        // Lime
        const val Lime: String = LIME

        // Yellow
        const val Yellow: String = YELLOW

        // Amber
        const val Amber: String = AMBER

        // Orange
        const val Orange: String = ORANGE

        // DeepOrange
        const val DeepOrange: String = DEEPORANGE

        // Brown
        const val Brown: String = BROWN

        // Grey
        const val Grey: String = GREY

        // BlueGrey
        const val BlueGrey: String = BLUEGREY

        /**
         * randomThemeColor: [String]
         *
         * Gets a random ThemeColor
         *
         * @return [String] defining random Theme Color
         */
        val randomThemeColor: String
            get() {
                val array = arrayOf(
                    Red, Pink, Purple, DeepPurple, Indigo, Blue, LightBlue, Cyan, Teal,
                    Green, LightGreen, Lime, Yellow, Amber, Orange, DeepOrange,
                    Brown, Grey, BlueGrey
                )
                return array[Random().nextInt(array.size)]
            } // get()

    } // ThemeColor

    object AccentColor {
        // Red
        const val Red_A1: String = RED_A1
        const val Red_A2: String = RED_A2
        const val Red_A4: String = RED_A4
        const val Red_A7: String = RED_A7

        // Pink
        const val Pink_A1: String = PINK_A1
        const val Pink_A2: String = PINK_A2
        const val Pink_A4: String = PINK_A4
        const val Pink_A7: String = PINK_A7

        // Purple
        const val Purple_A1: String = PURPLE_A1
        const val Purple_A2: String = PURPLE_A2
        const val Purple_A4: String = PURPLE_A4
        const val Purple_A7: String = PURPLE_A7

        // DeepPurple
        const val DeepPurple_A1: String = DEEPPURPLE_A1
        const val DeepPurple_A2: String = DEEPPURPLE_A2
        const val DeepPurple_A4: String = DEEPPURPLE_A4
        const val DeepPurple_A7: String = DEEPPURPLE_A7

        // Indigo
        const val Indigo_A1: String = INDIGO_A1
        const val Indigo_A2: String = INDIGO_A2
        const val Indigo_A4: String = INDIGO_A4
        const val Indigo_A7: String = INDIGO_A7

        // Blue
        const val Blue_A1: String = BLUE_A1
        const val Blue_A2: String = BLUE_A2
        const val Blue_A4: String = BLUE_A4
        const val Blue_A7: String = BLUE_A7

        // LightBlue
        const val LightBlue_A1: String = LIGHTBLUE_A1
        const val LightBlue_A2: String = LIGHTBLUE_A2
        const val LightBlue_A4: String = LIGHTBLUE_A4
        const val LightBlue_A7: String = LIGHTBLUE_A7

        // Cyan
        const val Cyan_A1: String = CYAN_A1
        const val Cyan_A2: String = CYAN_A2
        const val Cyan_A4: String = CYAN_A4
        const val Cyan_A7: String = CYAN_A7

        // Teal
        const val Teal_A1: String = TEAL_A1
        const val Teal_A2: String = TEAL_A2
        const val Teal_A4: String = TEAL_A4
        const val Teal_A7: String = TEAL_A7

        // Green
        const val Green_A1: String = GREEN_A1
        const val Green_A2: String = GREEN_A2
        const val Green_A4: String = GREEN_A4
        const val Green_A7: String = GREEN_A7

        // LightGreen
        const val LightGreen_A1: String = LIGHTGREEN_A1
        const val LightGreen_A2: String = LIGHTGREEN_A2
        const val LightGreen_A4: String = LIGHTGREEN_A4
        const val LightGreen_A7: String = LIGHTGREEN_A7

        // Lime
        const val Lime_A1: String = LIME_A1
        const val Lime_A2: String = LIME_A2
        const val Lime_A4: String = LIME_A4
        const val Lime_A7: String = LIME_A7

        // Yellow
        const val Yellow_A1: String = YELLOW_A1
        const val Yellow_A2: String = YELLOW_A2
        const val Yellow_A4: String = YELLOW_A4
        const val Yellow_A7: String = YELLOW_A7

        // Amber
        const val Amber_A1: String = AMBER_A1
        const val Amber_A2: String = AMBER_A2
        const val Amber_A4: String = AMBER_A4
        const val Amber_A7: String = AMBER_A7

        // Orange
        const val Orange_A1: String = ORANGE_A1
        const val Orange_A2: String = ORANGE_A2
        const val Orange_A4: String = ORANGE_A4
        const val Orange_A7: String = ORANGE_A7

        // DeepOrange
        const val DeepOrange_A1: String = DEEPORANGE_A1
        const val DeepOrange_A2: String = DEEPORANGE_A2
        const val DeepOrange_A4: String = DEEPORANGE_A4
        const val DeepOrange_A7: String = DEEPORANGE_A7

        // Brown
        private const val Brown_A3: String = BROWN_3

        // Grey
        private const val Grey_A3: String = GREY_3

        // BlueGrey
        private const val BlueGrey_A3: String = BLUEGREY_3

        /**
         * randomAccentColor: [String]
         *
         * Gets a random Accent Color
         *
         * @return [String] defining random Accent Color
         */
        val randomAccentColor: String
            get() {
                val array = arrayOf(
                    Red_A1, Red_A2, Red_A4, Red_A7,
                    Pink_A1, Pink_A2, Pink_A4, Pink_A7,
                    Purple_A1, Purple_A2, Purple_A4, Purple_A7,
                    DeepPurple_A1, DeepPurple_A2, DeepPurple_A4, DeepPurple_A7,
                    Indigo_A1, Indigo_A2, Indigo_A4, Indigo_A7,
                    Blue_A1, Blue_A2, Blue_A4, Blue_A7,
                    LightBlue_A1, LightBlue_A2, LightBlue_A4, LightBlue_A7,
                    Cyan_A1, Cyan_A2, Cyan_A4, Cyan_A7,
                    Teal_A1, Teal_A2, Teal_A4, Teal_A7,
                    Green_A1, Green_A2, Green_A4, Green_A7,
                    LightGreen_A1, LightGreen_A2, LightGreen_A4, LightGreen_A7,
                    Lime_A1, Lime_A2, Lime_A4, Lime_A7,
                    Yellow_A1, Yellow_A2, Yellow_A4, Yellow_A7,
                    Amber_A1, Amber_A2, Amber_A4, Amber_A7,
                    Orange_A1, Orange_A2, Orange_A4, Orange_A7,
                    DeepOrange_A1, DeepOrange_A2, DeepOrange_A4, DeepOrange_A7,
                    Brown_A3, Grey_A3, BlueGrey_A3
                )
                return array[Random().nextInt(array.size)]
            } // get()
    } // AccentColor

} // Class
