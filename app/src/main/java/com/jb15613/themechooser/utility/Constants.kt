package com.jb15613.themechooser.utility

import android.content.Context
import android.content.pm.ApplicationInfo
import android.util.Log
import com.jb15613.themechooser.demo.BuildConfig
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

const val APP_TITLE = "MTC Pref Demo"

const val NAV_ITEM_NAV = "Navigation"
const val NAV_ITEM_TEXT_VIEWS = "Text Views"
const val NAV_ITEM_BUTTON_VIEWS = "Button Views"
const val NAV_ITEM_WIDGET_VIEWS = "Widget Views"
const val NAV_ITEM_OPTIONS = "App Options"
const val NAV_ITEM_SETTINGS = "Settings"
const val NAV_ITEM_LOG = "Send Log"
const val NAV_ITEM_UPDATE = "Check For Update"
const val NAV_ITEM_SPARE_PARTS = "Spare Parts"
const val NAV_ITEM_HEADER = APP_TITLE

const val PACKAGE = "com.jb15613.themechooser.demo"

fun isDebugMode(): Boolean {
    return BuildConfig.DEBUG
}

fun getAppTimeStamp(context: Context): String {
    val timeStamp: String
    var ts = ""
    try {
        val appInfo: ApplicationInfo = context.packageManager.getApplicationInfo(context.packageName, 0)
        val appFile = appInfo.sourceDir
        val time: Long = File(appFile).lastModified()
        val formatter = SimpleDateFormat("MM/dd/yy h:mm a", Locale.US)
        timeStamp = formatter.format(time)
        val items = timeStamp.split(" ".toRegex()).toTypedArray()
        for (i in items.indices) {
            when (i) {
                0 ->                         // date
                    ts += "Built on <font color='" + ColorUtils.getColorAsHtmlString(
                        ThemeChooserUtils.getThemeColor()) + "'> " + items[i] + "</font>"
                1 ->                         // time
                    ts += " @ <font color='" + ColorUtils.getColorAsHtmlString(
                        ThemeChooserUtils.getThemeColor()) + "'> " + items[i] + "</font>"
                2 ->                         // am/pm
                    ts += " <font color='" + ColorUtils.getColorAsHtmlString(
                        ThemeChooserUtils.getThemeColor()) + "'> " + items[i] + "</font>"
            }
        }

    } catch (e: Exception) {
        e.printStackTrace()
    }
    Log.e("getAppTimeStamp", ts)
    return ts
}