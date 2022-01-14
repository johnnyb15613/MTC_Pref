package com.jb15613.themechooser.utility

import android.content.Context
import android.graphics.Color

import android.util.TypedValue
import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.utility.PrefUtils.getThemeHue


object ThemeChooserUtils {

    /**
     * getThemeColor(context: [Context]): [Int]
     *
     * Retrieves color value of Primary Theme Color
     *
     * @param context a [Context] that is used to retrieve a theme object
     *
     * @return [Int] that is the color value for Primary Theme Color
     */
    fun getThemeColor(context: Context): Int {
        val typedValue = TypedValue()
        return if (context.theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            typedValue.data
        } else {
            Color.TRANSPARENT
        }
    } // getThemeColor

    /**
     * getThemeColor(context: [Context], opacity: [Float]): [Int]
     *
     * Retrieves color value of Primary Theme Color with Opacity
     *
     * @param context a [Context] that is used to retrieve a theme object
     * @param opacity a [Float] that is used to derive an opaque version of a solid color
     *
     * @return [Int] that is the color value for Primary Theme Color with desired opacity
     */
    fun getThemeColor(context: Context, opacity: Float): Int {
        val typedValue = TypedValue()
        return if (context.theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            val color: Int = when (opacity.toDouble()) {
                1.0 -> typedValue.data
                0.9 -> typedValue.data and 0x00FFFFFF or -0x20000000
                0.8 -> typedValue.data and 0x00FFFFFF or -0x30000000
                0.7 -> typedValue.data and 0x00FFFFFF or -0x40000000
                0.6 -> typedValue.data and 0x00FFFFFF or -0x50000000
                0.5 -> typedValue.data and 0x00FFFFFF or -0x60000000
                0.4 -> typedValue.data and 0x00FFFFFF or -0x70000000
                0.3 -> typedValue.data and 0x00FFFFFF or -0x80000000
                0.2 -> typedValue.data and 0x00FFFFFF or 0x70000000
                0.1 -> typedValue.data and 0x00FFFFFF or 0x60000000
                else -> Color.TRANSPARENT
            }
            color
        } else {
            Color.TRANSPARENT
        }
    } // getThemeColor

    /**
     * getThemeDarkColor(context: [Context]): [Int]
     *
     * Retrieves color value of Primary Theme Color Dark
     *
     * @param context a [Context] that is used to retrieve a theme object
     *
     * @return [Int] that is the color value for Primary Theme Color Dark
     */
    fun getThemeDarkColor(context: Context): Int {
        val typedValue = TypedValue()
        return if (context.theme.resolveAttribute(R.attr.colorPrimaryDark, typedValue, true)) {
            typedValue.data
        } else {
            Color.TRANSPARENT
        }
    } // getThemeDarkColor

    /**
     * getThemeDarkColor(context: [Context], opacity: [Float]): [Int]
     *
     * Retrieves color value of Primary Theme Color Dark with Opacity
     *
     * @param context a [Context] that is used to retrieve a theme object
     * @param opacity a [Float] that is used to derive an opaque version of a solid color\
     *
     * @return [Int] that is the color value for Primary Theme Color Dark with desired opacity
     */
    fun getThemeDarkColor(context: Context, opacity: Float): Int {
        val typedValue = TypedValue()
        return if (context.theme.resolveAttribute(R.attr.colorPrimaryDark, typedValue, true)) {
            val color: Int = when (opacity.toDouble()) {
                1.0 -> typedValue.data
                0.9 -> typedValue.data and 0x00FFFFFF or -0x20000000
                0.8 -> typedValue.data and 0x00FFFFFF or -0x30000000
                0.7 -> typedValue.data and 0x00FFFFFF or -0x40000000
                0.6 -> typedValue.data and 0x00FFFFFF or -0x50000000
                0.5 -> typedValue.data and 0x00FFFFFF or -0x60000000
                0.4 -> typedValue.data and 0x00FFFFFF or -0x70000000
                0.3 -> typedValue.data and 0x00FFFFFF or -0x80000000
                0.2 -> typedValue.data and 0x00FFFFFF or 0x70000000
                0.1 -> typedValue.data and 0x00FFFFFF or 0x60000000
                else -> Color.TRANSPARENT
            }
            color
        } else {
            Color.TRANSPARENT
        }
    } // getThemeDarkColor

    /**
     * getThemeAccentColor(context: [Context]): [Int]
     *
     * Retrieves color value of Accent Theme Color
     *
     * @param context a `Context` that is used to retrieve a theme object
     *
     * @return [Int] that is the color value for Accent Theme Color
     */
    fun getThemeAccentColor(context: Context): Int {
        val typedValue = TypedValue()
        return if (context.theme.resolveAttribute(R.attr.colorAccent, typedValue, true)) {
            typedValue.data
        } else {
            Color.TRANSPARENT
        }
    } // getThemeAccentColor

    /**
     * getThemeAccentColor(context: [Context], opacity: [Float]): [Int]
     *
     * Retrieves color value of Accent Theme Color with Opacity
     *
     * @param context a [Context] that is used to retrieve a theme object
     * @param opacity a [Float] that is used to derive an opaque version of a solid color
     *
     * @return [Int] that is the color value for Accent Theme Color with desired opacity
     */
    fun getThemeAccentColor(context: Context, opacity: Float): Int {
        val typedValue = TypedValue()
        return if (context.theme.resolveAttribute(R.attr.colorPrimary, typedValue, true)) {
            val color: Int = when (opacity.toDouble()) {
                1.0 -> typedValue.data
                0.9 -> typedValue.data and 0x00FFFFFF or -0x20000000
                0.8 -> typedValue.data and 0x00FFFFFF or -0x30000000
                0.7 -> typedValue.data and 0x00FFFFFF or -0x40000000
                0.6 -> typedValue.data and 0x00FFFFFF or -0x50000000
                0.5 -> typedValue.data and 0x00FFFFFF or -0x60000000
                0.4 -> typedValue.data and 0x00FFFFFF or -0x70000000
                0.3 -> typedValue.data and 0x00FFFFFF or -0x80000000
                0.2 -> typedValue.data and 0x00FFFFFF or 0x70000000
                0.1 -> typedValue.data and 0x00FFFFFF or 0x60000000
                else -> Color.TRANSPARENT
            }
            color
        } else {
            Color.TRANSPARENT
        }
    } // getThemeAccentColor

    /**
     * getPrimaryBgColor(context: [Context]): [Int]
     *
     * Retrieves color value of Primary BG Color
     *
     * @param context a [Context] that is used to retrieve a theme object
     *
     * @return [Int] that is the color value for Primary BG Color
     */
    fun getPrimaryBgColor(context: Context): Int {
        val typedValue = TypedValue()
        return if (context.theme.resolveAttribute(R.attr.primaryBgColor, typedValue, true)) {
            typedValue.data
        } else {
            Color.TRANSPARENT
        }
    } // getPrimaryBgColor

    /**
     * getSecondaryBgColor(context: [Context]): [Int]
     *
     * Retrieves color value of Secondary BG Color
     *
     * @param context a [Context] that is used to retrieve a theme object
     *
     * @return [Int] that is the color value for Secondary BG Color
     */
    fun getSecondaryBgColor(context: Context): Int {
        val typedValue = TypedValue()
        return if (context.theme.resolveAttribute(R.attr.secondaryBgColor, typedValue, true)) {
            typedValue.data
        } else {
            Color.TRANSPARENT
        }
    } // getSecondaryBgColor

    /**
     * getPrimaryTextColor(context: [Context]): [Int]
     *
     * Retrieves color value of Primary Text Color
     *
     * @param context a [Context] that is used to retrieve a theme object
     *
     * @return [Int] that is the color value for Primary Text Color
     */
    fun getPrimaryTextColor(context: Context): Int {
        val typedValue = TypedValue()
        return if (context.theme.resolveAttribute(R.attr.textColorPrimary, typedValue, true)) {
            typedValue.data
        } else {
            Color.TRANSPARENT
        }
    } // getPrimaryTextColor

    /**
     * getSecondaryTextColor(context: [Context]): [Int]
     *
     * Retrieves color value of Secondary Text Color
     *
     * @param context a [Context] that is used to retrieve a theme object
     *
     * @return [Int] that is the color value for Secondary Text Color
     */
    fun getSecondaryTextColor(context: Context): Int {
        val typedValue = TypedValue()
        return if (context.theme
                .resolveAttribute(R.attr.textColorSecondary, typedValue, true)
        ) {
            typedValue.data
        } else {
            Color.TRANSPARENT
        }
    } // getSecondaryTextColor

    /**
     * isLightTheme(context: [Context]): [Boolean]
     *
     * Retrieves color value of Secondary Text Color
     *
     * @param context a [Context] that is used to retrieve a theme object
     *
     * @return [Boolean] that is true for light, and false or dark
     */
    fun isLightTheme(context: Context): Boolean {
        return getThemeHue(context)
    }
} // Class
