package com.jb15613.themechooser.utility

import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat
import com.jb15613.themechooser.mtcpref.R

object ColorStringIntSwitcher {

    fun switchColorToInt(argColor: String, res: Resources): Int {

        var color = 0

        when (argColor) {

            RED -> color = ResourcesCompat.getColor(res, R.color.material_primary_red, null)
            RED_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_red, null)
            RED_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_red2, null)
            RED_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_red4, null)
            RED_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_red7, null)

            PINK -> color = ResourcesCompat.getColor(res, R.color.material_primary_pink, null)
            PINK_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_pink, null)
            PINK_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_pink2, null)
            PINK_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_pink4, null)
            PINK_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_pink7, null)

            PURPLE -> color = ResourcesCompat.getColor(res, R.color.material_primary_purple, null)
            PURPLE_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_purple, null)
            PURPLE_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_purple2, null)
            PURPLE_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_purple4, null)
            PURPLE_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_purple7, null)

            DEEPPURPLE -> color = ResourcesCompat.getColor(res, R.color.material_primary_deepPurple, null)
            DEEPPURPLE_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_deepPurple, null)
            DEEPPURPLE_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_deepPurple2, null)
            DEEPPURPLE_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_deepPurple4, null)
            DEEPPURPLE_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_deepPurple7, null)

            INDIGO -> color = ResourcesCompat.getColor(res, R.color.material_primary_indigo, null)
            INDIGO_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_indigo, null)
            INDIGO_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_indigo2, null)
            INDIGO_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_indigo4, null)
            INDIGO_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_indigo7, null)

            BLUE -> color = ResourcesCompat.getColor(res, R.color.material_primary_blue, null)
            BLUE_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_blue, null)
            BLUE_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_blue2, null)
            BLUE_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_blue4, null)
            BLUE_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_blue7, null)

            LIGHTBLUE -> color = ResourcesCompat.getColor(res, R.color.material_primary_lightBlue, null)
            LIGHTBLUE_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lightBlue, null)
            LIGHTBLUE_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lightBlue2, null)
            LIGHTBLUE_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lightBlue4, null)
            LIGHTBLUE_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lightBlue7, null)

            CYAN -> color = ResourcesCompat.getColor(res, R.color.material_primary_cyan, null)
            CYAN_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_cyan, null)
            CYAN_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_cyan2, null)
            CYAN_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_cyan4, null)
            CYAN_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_cyan7, null)

            TEAL -> color = ResourcesCompat.getColor(res, R.color.material_primary_teal, null)
            TEAL_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_teal, null)
            TEAL_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_teal2, null)
            TEAL_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_teal4, null)
            TEAL_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_teal7, null)

            GREEN -> color = ResourcesCompat.getColor(res, R.color.material_primary_green, null)
            GREEN_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_green, null)
            GREEN_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_green2, null)
            GREEN_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_green4, null)
            GREEN_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_green7, null)

            LIGHTGREEN -> color = ResourcesCompat.getColor(res, R.color.material_primary_lightGreen, null)
            LIGHTGREEN_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lightGreen, null)
            LIGHTGREEN_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lightGreen2, null)
            LIGHTGREEN_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lightGreen4, null)
            LIGHTGREEN_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lightGreen7, null)

            LIME -> color = ResourcesCompat.getColor(res, R.color.material_primary_lime, null)
            LIME_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lime, null)
            LIME_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lime2, null)
            LIME_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lime4, null)
            LIME_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_lime7, null)

            YELLOW -> color = ResourcesCompat.getColor(res, R.color.material_primary_yellow, null)
            YELLOW_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_yellow, null)
            YELLOW_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_yellow2, null)
            YELLOW_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_yellow4, null)
            YELLOW_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_yellow7, null)

            AMBER -> color = ResourcesCompat.getColor(res, R.color.material_primary_amber, null)
            AMBER_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_amber, null)
            AMBER_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_amber2, null)
            AMBER_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_amber4, null)
            AMBER_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_amber7, null)

            ORANGE -> color = ResourcesCompat.getColor(res, R.color.material_primary_orange, null)
            ORANGE_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_orange, null)
            ORANGE_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_orange2, null)
            ORANGE_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_orange4, null)
            ORANGE_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_orange7, null)

            DEEPORANGE -> color = ResourcesCompat.getColor(res, R.color.material_primary_deepOrange, null)
            DEEPORANGE_A1 -> color = ResourcesCompat.getColor(res, R.color.material_accent_deepOrange, null)
            DEEPORANGE_A2 -> color = ResourcesCompat.getColor(res, R.color.material_accent_deepOrange2, null)
            DEEPORANGE_A4 -> color = ResourcesCompat.getColor(res, R.color.material_accent_deepOrange4, null)
            DEEPORANGE_A7 -> color = ResourcesCompat.getColor(res, R.color.material_accent_deepOrange7, null)

            BROWN -> color = ResourcesCompat.getColor(res, R.color.material_primary_brown, null)
            BROWN_3 -> color = ResourcesCompat.getColor(res, R.color.material_accent_brown, null)

            GREY -> color = ResourcesCompat.getColor(res, R.color.material_primary_grey, null)
            GREY_3 -> color = ResourcesCompat.getColor(res, R.color.material_accent_grey, null)

            BLUEGREY -> color = ResourcesCompat.getColor(res, R.color.material_primary_blueGrey, null)
            BLUEGREY_3 -> color = ResourcesCompat.getColor(res, R.color.material_accent_blueGrey, null)

        } // when loop

        return color

    } // switchColorToInt

}