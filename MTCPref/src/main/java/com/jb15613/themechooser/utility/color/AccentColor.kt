package com.jb15613.themechooser.utility.color

import android.content.Context
import androidx.core.content.res.ResourcesCompat
import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.utility.*

class AccentColor {

    /**
     * getAccentColor(themeName: [String], mContext: [Context]) : [Int]
     *
     * This method gets light version of theme
     *
     * @param themeName a [String] containing the Theme Name
     * @param mContext a [Context] used to get Resources
     *
     * @return [Int] the appropriate Accent Color
     */
    fun getColor(themeName: String, mContext: Context): Int {

        var color = 0
        val r = mContext.resources

        when (themeName) {
            RED -> color = ResourcesCompat.getColor(r, R.color.red500, null)
            RED_A1 -> color = ResourcesCompat.getColor(r, R.color.redA100, null)
            RED_A2 -> color = ResourcesCompat.getColor(r, R.color.redA200, null)
            RED_A4 -> color = ResourcesCompat.getColor(r, R.color.redA400, null)
            RED_A7 -> color = ResourcesCompat.getColor(r, R.color.redA700, null)

            PINK -> color = ResourcesCompat.getColor(r, R.color.pink500, null)
            PINK_A1 -> color = ResourcesCompat.getColor(r, R.color.pinkA100, null)
            PINK_A2 -> color = ResourcesCompat.getColor(r, R.color.pinkA200, null)
            PINK_A4 -> color = ResourcesCompat.getColor(r, R.color.pinkA400, null)
            PINK_A7 -> color = ResourcesCompat.getColor(r, R.color.pinkA700, null)

            PURPLE -> color = ResourcesCompat.getColor(r, R.color.purple500, null)
            PURPLE_A1 -> color = ResourcesCompat.getColor(r, R.color.purpleA100, null)
            PURPLE_A2 -> color = ResourcesCompat.getColor(r, R.color.purpleA200, null)
            PURPLE_A4 -> color = ResourcesCompat.getColor(r, R.color.purpleA400, null)
            PURPLE_A7 -> color = ResourcesCompat.getColor(r, R.color.purpleA700, null)

            DEEPPURPLE -> color = ResourcesCompat.getColor(r, R.color.deeppurple500, null)
            DEEPPURPLE_A1 -> color = ResourcesCompat.getColor(r, R.color.deeppurpleA100, null)
            DEEPPURPLE_A2 -> color = ResourcesCompat.getColor(r, R.color.deeppurpleA200, null)
            DEEPPURPLE_A4 -> color = ResourcesCompat.getColor(r, R.color.deeppurpleA400, null)
            DEEPPURPLE_A7 -> color = ResourcesCompat.getColor(r, R.color.deeppurpleA700, null)

            INDIGO -> color = ResourcesCompat.getColor(r, R.color.indigo500, null)
            INDIGO_A1 -> color = ResourcesCompat.getColor(r, R.color.indigoA100, null)
            INDIGO_A2 -> color = ResourcesCompat.getColor(r, R.color.indigoA200, null)
            INDIGO_A4 -> color = ResourcesCompat.getColor(r, R.color.indigoA400, null)
            INDIGO_A7 -> color = ResourcesCompat.getColor(r, R.color.indigoA700, null)

            BLUE -> color = ResourcesCompat.getColor(r, R.color.blue500, null)
            BLUE_A1 -> color = ResourcesCompat.getColor(r, R.color.blueA100, null)
            BLUE_A2 -> color = ResourcesCompat.getColor(r, R.color.blueA200, null)
            BLUE_A4 -> color = ResourcesCompat.getColor(r, R.color.blueA400, null)
            BLUE_A7 -> color = ResourcesCompat.getColor(r, R.color.blueA700, null)

            LIGHTBLUE -> color = ResourcesCompat.getColor(r, R.color.lightblue500, null)
            LIGHTBLUE_A1 -> color = ResourcesCompat.getColor(r, R.color.lightblueA100, null)
            LIGHTBLUE_A2 -> color = ResourcesCompat.getColor(r, R.color.lightblueA200, null)
            LIGHTBLUE_A4 -> color = ResourcesCompat.getColor(r, R.color.lightblueA400, null)
            LIGHTBLUE_A7 -> color = ResourcesCompat.getColor(r, R.color.lightblueA700, null)

            CYAN -> color = ResourcesCompat.getColor(r, R.color.cyan500, null)
            CYAN_A1 -> color = ResourcesCompat.getColor(r, R.color.cyanA100, null)
            CYAN_A2 -> color = ResourcesCompat.getColor(r, R.color.cyanA200, null)
            CYAN_A4 -> color = ResourcesCompat.getColor(r, R.color.cyanA400, null)
            CYAN_A7 -> color = ResourcesCompat.getColor(r, R.color.cyanA700, null)

            TEAL -> color = ResourcesCompat.getColor(r, R.color.teal500, null)
            TEAL_A1 -> color = ResourcesCompat.getColor(r, R.color.tealA100, null)
            TEAL_A2 -> color = ResourcesCompat.getColor(r, R.color.tealA200, null)
            TEAL_A4 -> color = ResourcesCompat.getColor(r, R.color.tealA400, null)
            TEAL_A7 -> color = ResourcesCompat.getColor(r, R.color.tealA700, null)

            GREEN -> color = ResourcesCompat.getColor(r, R.color.green500, null)
            GREEN_A1 -> color = ResourcesCompat.getColor(r, R.color.greenA100, null)
            GREEN_A2 -> color = ResourcesCompat.getColor(r, R.color.greenA200, null)
            GREEN_A4 -> color = ResourcesCompat.getColor(r, R.color.greenA400, null)
            GREEN_A7 -> color = ResourcesCompat.getColor(r, R.color.greenA700, null)

            LIGHTGREEN -> color = ResourcesCompat.getColor(r, R.color.lightgreen500, null)
            LIGHTGREEN_A1 -> color = ResourcesCompat.getColor(r, R.color.lightgreenA100, null)
            LIGHTGREEN_A2 -> color = ResourcesCompat.getColor(r, R.color.lightgreenA200, null)
            LIGHTGREEN_A4 -> color = ResourcesCompat.getColor(r, R.color.lightgreenA400, null)
            LIGHTGREEN_A7 -> color = ResourcesCompat.getColor(r, R.color.lightgreenA700, null)

            LIME -> color = ResourcesCompat.getColor(r, R.color.lime500, null)
            LIME_A1 -> color = ResourcesCompat.getColor(r, R.color.limeA100, null)
            LIME_A2 -> color = ResourcesCompat.getColor(r, R.color.limeA200, null)
            LIME_A4 -> color = ResourcesCompat.getColor(r, R.color.limeA400, null)
            LIME_A7 -> color = ResourcesCompat.getColor(r, R.color.limeA700, null)

            YELLOW -> color = ResourcesCompat.getColor(r, R.color.yellow500, null)
            YELLOW_A1 -> color = ResourcesCompat.getColor(r, R.color.yellowA100, null)
            YELLOW_A2 -> color = ResourcesCompat.getColor(r, R.color.yellowA200, null)
            YELLOW_A4 -> color = ResourcesCompat.getColor(r, R.color.yellowA400, null)
            YELLOW_A7 -> color = ResourcesCompat.getColor(r, R.color.yellowA700, null)

            AMBER -> color = ResourcesCompat.getColor(r, R.color.amber500, null)
            AMBER_A1 -> color = ResourcesCompat.getColor(r, R.color.amberA100, null)
            AMBER_A2 -> color = ResourcesCompat.getColor(r, R.color.amberA200, null)
            AMBER_A4 -> color = ResourcesCompat.getColor(r, R.color.amberA400, null)
            AMBER_A7 -> color = ResourcesCompat.getColor(r, R.color.amberA700, null)

            ORANGE -> color = ResourcesCompat.getColor(r, R.color.orange500, null)
            ORANGE_A1 -> color = ResourcesCompat.getColor(r, R.color.orangeA100, null)
            ORANGE_A2 -> color = ResourcesCompat.getColor(r, R.color.orangeA200, null)
            ORANGE_A4 -> color = ResourcesCompat.getColor(r, R.color.orangeA400, null)
            ORANGE_A7 -> color = ResourcesCompat.getColor(r, R.color.orangeA700, null)

            DEEPORANGE -> color = ResourcesCompat.getColor(r, R.color.deeporange500, null)
            DEEPORANGE_A1 -> color = ResourcesCompat.getColor(r, R.color.deeporangeA100, null)
            DEEPORANGE_A2 -> color = ResourcesCompat.getColor(r, R.color.deeporangeA200, null)
            DEEPORANGE_A4 -> color = ResourcesCompat.getColor(r, R.color.deeporangeA400, null)
            DEEPORANGE_A7 -> color = ResourcesCompat.getColor(r, R.color.deeporangeA700, null)

            BROWN -> color = ResourcesCompat.getColor(r, R.color.brown500, null)
            BROWN_3 -> color = ResourcesCompat.getColor(r, R.color.brown300, null)

            GREY -> color = ResourcesCompat.getColor(r, R.color.grey500, null)
            GREY_3 -> color = ResourcesCompat.getColor(r, R.color.grey300, null)

            BLUEGREY -> color = ResourcesCompat.getColor(r, R.color.bluegrey500, null)
            BLUEGREY_3 -> color = ResourcesCompat.getColor(r, R.color.bluegrey300, null)
        }

        return color

    } // getColor()

} // Class