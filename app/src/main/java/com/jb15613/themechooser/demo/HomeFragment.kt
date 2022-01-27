package com.jb15613.themechooser.demo

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.jb15613.themechooser.component.ChooserSwatch
import com.jb15613.themechooser.mtcpref.Themes
import com.jb15613.themechooser.utility.HOME_INFO
import com.jb15613.themechooser.utility.ThemeChooserUtils
import java.util.*

class HomeFragment: Fragment(R.layout.activity_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // val someInt = requireArguments().getInt("some_int")
        val sampleTextView: TextView = view.findViewById(R.id.sampleInfoTextView)
        sampleTextView.text = HOME_INFO

        val swatch: ChooserSwatch = view.findViewById(R.id.csv)

        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                swatch.setAllCircleColors(ThemeChooserUtils.getRandomColorSet())
            }
        }, 0, 3000)

        val swatch2: ChooserSwatch = view.findViewById(R.id.csv2)

        Timer().scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
                swatch2.setAllCircleColors(ThemeChooserUtils.getRandomThemeColorSet())
            }
        }, 0, 3000)

    }

}