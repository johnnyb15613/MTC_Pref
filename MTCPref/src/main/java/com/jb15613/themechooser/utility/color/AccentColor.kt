package com.jb15613.themechooser.utility.color

import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat
import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.startup.AccentColorInitializer
import com.jb15613.themechooser.utility.*

/**
## Utilities for Retrieving *Accent* Colors
 */
object AccentColor {

    private var mResources: Resources

    var isInitialized = false

    init {
        isInitialized = true
        mResources = AccentColorInitializer.getAcResources()
    }

    /**
     ## This will retrieve the specified Accent Color
     *
     * @param themeName a [String] containing the Theme Name
     *
     * @return [Int] the appropriate Accent Color
     */
    fun getColor(themeName: String): Int {

        var color = 0

        when (themeName) {
            RED -> color = ResourcesCompat.getColor(mResources, R.color.red500, null)
            RED_A1 -> color = ResourcesCompat.getColor(mResources, R.color.redA100, null)
            RED_A2 -> color = ResourcesCompat.getColor(mResources, R.color.redA200, null)
            RED_A4 -> color = ResourcesCompat.getColor(mResources, R.color.redA400, null)
            RED_A7 -> color = ResourcesCompat.getColor(mResources, R.color.redA700, null)

            PINK -> color = ResourcesCompat.getColor(mResources, R.color.pink500, null)
            PINK_A1 -> color = ResourcesCompat.getColor(mResources, R.color.pinkA100, null)
            PINK_A2 -> color = ResourcesCompat.getColor(mResources, R.color.pinkA200, null)
            PINK_A4 -> color = ResourcesCompat.getColor(mResources, R.color.pinkA400, null)
            PINK_A7 -> color = ResourcesCompat.getColor(mResources, R.color.pinkA700, null)

            PURPLE -> color = ResourcesCompat.getColor(mResources, R.color.purple500, null)
            PURPLE_A1 -> color = ResourcesCompat.getColor(mResources, R.color.purpleA100, null)
            PURPLE_A2 -> color = ResourcesCompat.getColor(mResources, R.color.purpleA200, null)
            PURPLE_A4 -> color = ResourcesCompat.getColor(mResources, R.color.purpleA400, null)
            PURPLE_A7 -> color = ResourcesCompat.getColor(mResources, R.color.purpleA700, null)

            DEEPPURPLE -> color = ResourcesCompat.getColor(mResources, R.color.deeppurple500, null)
            DEEPPURPLE_A1 -> color = ResourcesCompat.getColor(mResources, R.color.deeppurpleA100, null)
            DEEPPURPLE_A2 -> color = ResourcesCompat.getColor(mResources, R.color.deeppurpleA200, null)
            DEEPPURPLE_A4 -> color = ResourcesCompat.getColor(mResources, R.color.deeppurpleA400, null)
            DEEPPURPLE_A7 -> color = ResourcesCompat.getColor(mResources, R.color.deeppurpleA700, null)

            INDIGO -> color = ResourcesCompat.getColor(mResources, R.color.indigo500, null)
            INDIGO_A1 -> color = ResourcesCompat.getColor(mResources, R.color.indigoA100, null)
            INDIGO_A2 -> color = ResourcesCompat.getColor(mResources, R.color.indigoA200, null)
            INDIGO_A4 -> color = ResourcesCompat.getColor(mResources, R.color.indigoA400, null)
            INDIGO_A7 -> color = ResourcesCompat.getColor(mResources, R.color.indigoA700, null)

            BLUE -> color = ResourcesCompat.getColor(mResources, R.color.blue500, null)
            BLUE_A1 -> color = ResourcesCompat.getColor(mResources, R.color.blueA100, null)
            BLUE_A2 -> color = ResourcesCompat.getColor(mResources, R.color.blueA200, null)
            BLUE_A4 -> color = ResourcesCompat.getColor(mResources, R.color.blueA400, null)
            BLUE_A7 -> color = ResourcesCompat.getColor(mResources, R.color.blueA700, null)

            LIGHTBLUE -> color = ResourcesCompat.getColor(mResources, R.color.lightblue500, null)
            LIGHTBLUE_A1 -> color = ResourcesCompat.getColor(mResources, R.color.lightblueA100, null)
            LIGHTBLUE_A2 -> color = ResourcesCompat.getColor(mResources, R.color.lightblueA200, null)
            LIGHTBLUE_A4 -> color = ResourcesCompat.getColor(mResources, R.color.lightblueA400, null)
            LIGHTBLUE_A7 -> color = ResourcesCompat.getColor(mResources, R.color.lightblueA700, null)

            CYAN -> color = ResourcesCompat.getColor(mResources, R.color.cyan500, null)
            CYAN_A1 -> color = ResourcesCompat.getColor(mResources, R.color.cyanA100, null)
            CYAN_A2 -> color = ResourcesCompat.getColor(mResources, R.color.cyanA200, null)
            CYAN_A4 -> color = ResourcesCompat.getColor(mResources, R.color.cyanA400, null)
            CYAN_A7 -> color = ResourcesCompat.getColor(mResources, R.color.cyanA700, null)

            TEAL -> color = ResourcesCompat.getColor(mResources, R.color.teal500, null)
            TEAL_A1 -> color = ResourcesCompat.getColor(mResources, R.color.tealA100, null)
            TEAL_A2 -> color = ResourcesCompat.getColor(mResources, R.color.tealA200, null)
            TEAL_A4 -> color = ResourcesCompat.getColor(mResources, R.color.tealA400, null)
            TEAL_A7 -> color = ResourcesCompat.getColor(mResources, R.color.tealA700, null)

            GREEN -> color = ResourcesCompat.getColor(mResources, R.color.green500, null)
            GREEN_A1 -> color = ResourcesCompat.getColor(mResources, R.color.greenA100, null)
            GREEN_A2 -> color = ResourcesCompat.getColor(mResources, R.color.greenA200, null)
            GREEN_A4 -> color = ResourcesCompat.getColor(mResources, R.color.greenA400, null)
            GREEN_A7 -> color = ResourcesCompat.getColor(mResources, R.color.greenA700, null)

            LIGHTGREEN -> color = ResourcesCompat.getColor(mResources, R.color.lightgreen500, null)
            LIGHTGREEN_A1 -> color = ResourcesCompat.getColor(mResources, R.color.lightgreenA100, null)
            LIGHTGREEN_A2 -> color = ResourcesCompat.getColor(mResources, R.color.lightgreenA200, null)
            LIGHTGREEN_A4 -> color = ResourcesCompat.getColor(mResources, R.color.lightgreenA400, null)
            LIGHTGREEN_A7 -> color = ResourcesCompat.getColor(mResources, R.color.lightgreenA700, null)

            LIME -> color = ResourcesCompat.getColor(mResources, R.color.lime500, null)
            LIME_A1 -> color = ResourcesCompat.getColor(mResources, R.color.limeA100, null)
            LIME_A2 -> color = ResourcesCompat.getColor(mResources, R.color.limeA200, null)
            LIME_A4 -> color = ResourcesCompat.getColor(mResources, R.color.limeA400, null)
            LIME_A7 -> color = ResourcesCompat.getColor(mResources, R.color.limeA700, null)

            YELLOW -> color = ResourcesCompat.getColor(mResources, R.color.yellow500, null)
            YELLOW_A1 -> color = ResourcesCompat.getColor(mResources, R.color.yellowA100, null)
            YELLOW_A2 -> color = ResourcesCompat.getColor(mResources, R.color.yellowA200, null)
            YELLOW_A4 -> color = ResourcesCompat.getColor(mResources, R.color.yellowA400, null)
            YELLOW_A7 -> color = ResourcesCompat.getColor(mResources, R.color.yellowA700, null)

            AMBER -> color = ResourcesCompat.getColor(mResources, R.color.amber500, null)
            AMBER_A1 -> color = ResourcesCompat.getColor(mResources, R.color.amberA100, null)
            AMBER_A2 -> color = ResourcesCompat.getColor(mResources, R.color.amberA200, null)
            AMBER_A4 -> color = ResourcesCompat.getColor(mResources, R.color.amberA400, null)
            AMBER_A7 -> color = ResourcesCompat.getColor(mResources, R.color.amberA700, null)

            ORANGE -> color = ResourcesCompat.getColor(mResources, R.color.orange500, null)
            ORANGE_A1 -> color = ResourcesCompat.getColor(mResources, R.color.orangeA100, null)
            ORANGE_A2 -> color = ResourcesCompat.getColor(mResources, R.color.orangeA200, null)
            ORANGE_A4 -> color = ResourcesCompat.getColor(mResources, R.color.orangeA400, null)
            ORANGE_A7 -> color = ResourcesCompat.getColor(mResources, R.color.orangeA700, null)

            DEEPORANGE -> color = ResourcesCompat.getColor(mResources, R.color.deeporange500, null)
            DEEPORANGE_A1 -> color = ResourcesCompat.getColor(mResources, R.color.deeporangeA100, null)
            DEEPORANGE_A2 -> color = ResourcesCompat.getColor(mResources, R.color.deeporangeA200, null)
            DEEPORANGE_A4 -> color = ResourcesCompat.getColor(mResources, R.color.deeporangeA400, null)
            DEEPORANGE_A7 -> color = ResourcesCompat.getColor(mResources, R.color.deeporangeA700, null)

            BROWN -> color = ResourcesCompat.getColor(mResources, R.color.brown500, null)
            BROWN_3 -> color = ResourcesCompat.getColor(mResources, R.color.brown300, null)

            GREY -> color = ResourcesCompat.getColor(mResources, R.color.grey500, null)
            GREY_3 -> color = ResourcesCompat.getColor(mResources, R.color.grey300, null)

            BLUEGREY -> color = ResourcesCompat.getColor(mResources, R.color.bluegrey500, null)
            BLUEGREY_3 -> color = ResourcesCompat.getColor(mResources, R.color.bluegrey300, null)
        }

        return color

    } // getColor()

} // Class