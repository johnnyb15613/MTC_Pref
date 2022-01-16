package com.jb15613.themechooser.utility

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceFragmentCompat
import com.jb15613.themechooser.demo.MainActivity
import com.jb15613.themechooser.demo.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences, rootKey)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val c: Context = activity as Context
        view?.setBackgroundColor(ThemeChooserUtils.getPrimaryBgColor(c))
        var sBar = 0
        if (activity is MainActivity) {
            sBar = (activity as MainActivity).getStatusBarHeight()
        }
        view?.setPadding(0, sBar + 10, 0, 0)
        return view
    } // onCreateView
}