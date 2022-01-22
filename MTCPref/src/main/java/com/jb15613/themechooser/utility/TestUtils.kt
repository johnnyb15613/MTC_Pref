package com.jb15613.themechooser.utility

/**
## Utilities for Running Instrument And Unit Tests
 */
object TestUtils {

    /**
     ## Used to see if the current operation is being ran from an Android Test

     * @return [Boolean] that represents if running an *Android* Test
     */
    val isRunningAndroidTest : Boolean by lazy {
        try {
            Class.forName("androidx.test.espresso.Espresso")
            true
        } catch (e: ClassNotFoundException) {
            false
        }
    }

    /**
    ## Used to see if the current operation is being ran from a Unit Test

     * @return [Boolean] that represents if running a *Unit* Test
     */
    fun isRunningUnitTest(): Boolean {
        for (element in Thread.currentThread().stackTrace) {
            if (element.className.startsWith("org.junit.")) {
                return true
            }
        }
        return false
    }

}