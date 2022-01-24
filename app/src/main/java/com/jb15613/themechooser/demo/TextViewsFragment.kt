package com.jb15613.themechooser.demo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.jb15613.themechooser.utility.ThemeChooserUtils

class TextViewsFragment: Fragment(R.layout.activity_text_views) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // val someInt = requireArguments().getInt("some_int")

        val themeColorTextView: TextView = view.findViewById(R.id.themeColorTV)
        val themeDarkColorTextView: TextView = view.findViewById(R.id.themeDarkColorTV)
        val accentColorTextView: TextView = view.findViewById(R.id.themeAccentColorTV)
        val themePrimaryTextColorTextView: TextView = view.findViewById(R.id.themePrimaryTextColorTV)
        val themeSecondaryTextColorTextView: TextView = view.findViewById(R.id.themeSecondaryTextColorTV)

        val themeColor = ThemeChooserUtils.getColorAsHtmlString(ThemeChooserUtils.getThemeColor())
        val themeDarkColor = ThemeChooserUtils.getColorAsHtmlString(ThemeChooserUtils.getThemeDarkColor())
        val themeAccentColor = ThemeChooserUtils.getColorAsHtmlString(ThemeChooserUtils.getThemeAccentColor())
        val primaryTextColor = ThemeChooserUtils.getColorAsHtmlString(ThemeChooserUtils.getPrimaryTextColor())
        val secondaryTextColor = ThemeChooserUtils.getColorAsHtmlString(ThemeChooserUtils.getSecondaryTextColor())

        val themeColorName = ThemeChooserUtils.getColorNameAsString("Theme")
        val themeDarkColorName = ThemeChooserUtils.getColorNameAsString("ThemeDark")
        val accentColorName = ThemeChooserUtils.getColorNameAsString("Accent")
        val primaryTextColorName = ThemeChooserUtils.getColorNameAsString("PrimaryText")
        val secondaryTextColorName = ThemeChooserUtils.getColorNameAsString("SecondaryText")

        themeColorTextView.text = "Theme Color : $themeColor : $themeColorName"
        themeDarkColorTextView.text = "Theme Dark Color : $themeDarkColor : $themeDarkColorName"
        accentColorTextView.text = "Theme Accent Color : $themeAccentColor : $accentColorName"
        themePrimaryTextColorTextView.text = "Primary Text Color : $primaryTextColor : $primaryTextColorName"
        themeSecondaryTextColorTextView.text = "Secondary Text Color : $secondaryTextColor : $secondaryTextColorName"

    }

}