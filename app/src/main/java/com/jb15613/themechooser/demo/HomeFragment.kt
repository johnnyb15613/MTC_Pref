package com.jb15613.themechooser.demo

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.jb15613.themechooser.utility.HOME_INFO

class HomeFragment: Fragment(R.layout.activity_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // val someInt = requireArguments().getInt("some_int")
        val sampleTextView: TextView = view.findViewById(R.id.sampleInfoTextView)
        sampleTextView.text = HOME_INFO

    }

}