package com.jb15613.themechooser.utility

import com.jb15613.themechooser.mtcpref.BuildConfig

internal object DebugUtils {
    val isDebugMode: Boolean
        get() = BuildConfig.DEBUG
}