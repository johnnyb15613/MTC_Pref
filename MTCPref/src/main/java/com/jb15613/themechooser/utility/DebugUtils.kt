package com.jb15613.themechooser.utility

import com.jb15613.themechooser.mtcpref.BuildConfig

/**
## Utilities for Debugging
 */
internal object DebugUtils {

    /**
    ## Used to see if we are using *Debug Mode*
     * @return [Boolean] that is true if it is *Debug Mode*
     */
    val isDebugMode: Boolean
        get() = BuildConfig.DEBUG

} // Class