package com.jb15613.themechooser.utility

import android.content.res.Resources
import androidx.core.content.res.ResourcesCompat
import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.startup.ColorUtilsInitializer

object ColorUtils {

    private var mResources: Resources

    var isInitialized = false

    init {
        isInitialized = true
        mResources = ColorUtilsInitializer.mResources
    }

    /**
     * getColorSet(themeName: [String], isTrue: [Boolean]): [IntArray]
     *
     * Creates a set of colors that represent Primary, Dark, and Accent colors for a theme
     *
     * @param themeName a [String] that contains the Theme Name (eg: Purple)
     * @param isTrue a [Boolean] telling if its a custom accent color
     *
     * @return [IntArray] that contains Primary, Dark, and Accent theme colors
     */
    fun getColorSet(themeName: String, isTrue: Boolean): IntArray {
        // Light Green - Dark

        val colors = IntArray(3)
        var isCustom = false

        val tn: String
        var ta = ""

        if (themeName.contains(HUE_SPLITTER)) {
            // SHOULD ALWAYS BE TRUE
            val hueSplit: List<String> = themeName.split(HUE_SPLITTER)
            val hs1 = hueSplit[0] // Light Green
            if (hs1.contains(THEME_SPLITTER)) {
                isCustom = true
                val hsSplit: List<String> = hs1.split(THEME_SPLITTER)
                tn = hsSplit[0]
                ta = hsSplit[1]
            } else {
                tn = hs1 // Light Green
            }

        } else {
            if (themeName.contains(THEME_SPLITTER)) {
                isCustom = true
                val tnSplit: List<String> = themeName.split(THEME_SPLITTER)
                tn = tnSplit[0]
                ta = tnSplit[1]
            } else {
                tn = themeName
            }
        }

        if (isTrue) {
            isCustom = false
        }

        when (tn) {
            RED -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_red, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_red, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_red, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            PINK -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_pink, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_pink, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_pink, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            PURPLE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_purple, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_purple, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_purple, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            DEEPPURPLE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_deepPurple, null)
                colors[1] =
                    ResourcesCompat.getColor(mResources, R.color.material_primaryDark_deepPurple, null)
                if (!isCustom) {
                    colors[2] =
                        ResourcesCompat.getColor(mResources, R.color.material_accent_deepPurple, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            INDIGO -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_indigo, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_indigo, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_indigo, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            BLUE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_blue, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_blue, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_blue, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            LIGHTBLUE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_lightBlue, null)
                colors[1] =
                    ResourcesCompat.getColor(mResources, R.color.material_primaryDark_lightBlue, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_lightBlue, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            CYAN -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_cyan, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_cyan, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_cyan, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            TEAL -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_teal, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_teal, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_teal, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            GREEN -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_green, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_green, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_green, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            LIGHTGREEN -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_lightGreen, null)
                colors[1] =
                    ResourcesCompat.getColor(mResources, R.color.material_primaryDark_lightGreen, null)
                if (!isCustom) {
                    colors[2] =
                        ResourcesCompat.getColor(mResources, R.color.material_accent_lightGreen, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            LIME -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_lime, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_lime, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_lime, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            YELLOW -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_yellow, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_yellow, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_yellow, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            AMBER -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_amber, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_amber, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_amber, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            ORANGE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_orange, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_orange, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_orange, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            DEEPORANGE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_deepOrange, null)
                colors[1] =
                    ResourcesCompat.getColor(mResources, R.color.material_primaryDark_deepOrange, null)
                if (!isCustom) {
                    colors[2] =
                        ResourcesCompat.getColor(mResources, R.color.material_accent_deepOrange, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            BROWN -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_brown, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_brown, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_brown, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            GREY -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_grey, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_grey, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_grey, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }
            BLUEGREY -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_blueGrey, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_primaryDark_blueGrey, null)
                if (!isCustom) {
                    colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_blueGrey, null)
                } else {
                    colors[2] = getCustomAccentColor(ta)
                }
            }

        }

        return colors
    } // getColorSet()

    /**
     * getTrueAccentColorSet(themeName: [String]) : [IntArray]
     *
     * This function will return a list of all the true accent colors for each primary theme color
     *
     * @param themeName a [String] containing Theme Name (eg: Deep Orange)
     *
     * @return [IntArray] with all available hues of a theme color
     */
    fun getTrueAccentColorSet(themeName: String): IntArray {
        val colors = IntArray(5)

        when (themeName) {
            RED -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_red, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_red, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_red2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_red4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_red7, null)
            }
            PINK -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_pink, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_pink, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_pink2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_pink4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_pink7, null)
            }
            PURPLE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_purple, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_purple, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_purple2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_purple4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_purple7, null)
            }
            DEEPPURPLE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_deepPurple, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_deepPurple, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_deepPurple2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_deepPurple4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_deepPurple7, null)
            }
            INDIGO -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_indigo, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_indigo, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_indigo2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_indigo4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_indigo7, null)
            }
            BLUE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_blue, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_blue, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_blue2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_blue4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_blue7, null)
            }
            LIGHTBLUE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_lightBlue, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_lightBlue, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_lightBlue2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_lightBlue4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_lightBlue7, null)
            }
            CYAN -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_cyan, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_cyan, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_cyan2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_cyan4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_cyan7, null)
            }
            TEAL -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_teal, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_teal, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_teal2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_teal4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_teal7, null)
            }
            GREEN -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_green, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_green, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_green2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_green4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_green7, null)
            }
            LIGHTGREEN -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_lightGreen, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_lightGreen, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_lightGreen2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_lightGreen4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_lightGreen7, null)
            }
            LIME -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_lime, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_lime, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_lime2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_lime4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_lime7, null)
            }
            YELLOW -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_yellow, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_yellow, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_yellow2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_yellow4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_yellow7, null)
            }
            AMBER -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_amber, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_amber, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_amber2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_amber4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_amber7, null)
            }
            ORANGE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_orange, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_orange, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_orange2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_orange4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_orange7, null)
            }
            DEEPORANGE -> {
                colors[0] = ResourcesCompat.getColor(mResources, R.color.material_primary_deepOrange, null)
                colors[1] = ResourcesCompat.getColor(mResources, R.color.material_accent_deepOrange, null)
                colors[2] = ResourcesCompat.getColor(mResources, R.color.material_accent_deepOrange2, null)
                colors[3] = ResourcesCompat.getColor(mResources, R.color.material_accent_deepOrange4, null)
                colors[4] = ResourcesCompat.getColor(mResources, R.color.material_accent_deepOrange7, null)
            }
        }
        return colors
    } // getTrueAccentColorSet()

    /**
     * getCustomAccentColor()
     *
     * Retrieves an Accent Color that does not match the Primary Theme Color
     *
     * @param  themeName a String that contains the theme name
     *
     * @return [Int] that contains the Accent theme color
     */
    private fun getCustomAccentColor(themeName: String): Int {
        var color = 0

        when (themeName) {
            RED -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_red, null)
            PINK -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_pink, null)
            PURPLE -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_purple, null)
            DEEPPURPLE -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_deepPurple, null)
            INDIGO -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_indigo, null)
            BLUE -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_blue, null)
            LIGHTBLUE -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_lightBlue, null)
            CYAN -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_cyan, null)
            TEAL -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_teal, null)
            GREEN -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_green, null)
            LIGHTGREEN -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_lightGreen, null)
            LIME -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_lime, null)
            YELLOW -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_yellow, null)
            AMBER -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_amber, null)
            ORANGE -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_orange, null)
            DEEPORANGE -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_deepOrange, null)
            BROWN -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_brown, null)
            GREY -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_grey, null)
            BLUEGREY -> color = ResourcesCompat.getColor(mResources, R.color.material_primary_blueGrey, null)
        }

        return color
    } // getCustomAccentColor

    /**
     * getColorAsHtmlString([Int] color)
     *
     * Retrieves a color in the form of an HTML String
     *
     * @param color An Int that represents the color
     *
     * @return [String] that contains the formatted color for use in HTML
     */
    fun getColorAsHtmlString(color: Int): String {
        val s = Integer.toHexString(color)
        return "#$s"
    } // getColorAsHtmlString

} // Class