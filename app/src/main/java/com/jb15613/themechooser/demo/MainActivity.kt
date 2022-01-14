package com.jb15613.themechooser.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.jb15613.themechooser.mtcpref.Theme
import com.jb15613.themechooser.mtcpref.ThemeChooser
import com.jb15613.themechooser.mtcpref.Themes

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // setTheme(ThemeChooser.getTheme(this))

        setTheme(
            Theme.ThemeBuilder()
                .themeColor(Themes.ThemeColor.randomThemeColor)
                .accentColor(Themes.AccentColor.randomAccentColor)
                .isLightTheme(Themes.randomThemeHue)
                .build(this)
                .theme
        )

        // creates new theme object with desired parameters
        /*
        setTheme(new Theme.ThemeBuilder()
                                .themeColor(Themes.ThemeColor.getRandomThemeColor())
                                .accentColor(Themes.AccentColor.getRandomAccentColor())
                                .isLightTheme(Themes.getRandomThemeHue())
                                .build(this)
                                .getTheme());
        */

        // setTheme(ThemeChooser.getTheme(Themes.Cyan_Indigo_Dark));
        // setTheme(ThemeChooser.getTheme("Deep Purple"));
        // setTheme(ThemeChooser.getTheme("Deep Purple - Dark"));
        // setTheme(ThemeChooser.getTheme("Deep Purple - Light"));
        // setTheme(ThemeChooser.getTheme("Deep Purple & Pink"));
        // setTheme(ThemeChooser.getTheme("Deep Purple & Pink - Light"));
        // setTheme(ThemeChooser.getTheme("Purple & Deep Orange - Dark"));

        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)

    }
}