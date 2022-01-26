package com.jb15613.themechooser.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.jb15613.themechooser.mtcpref.R

class Swatch @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0) :
    ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.swatch_view, this, true)
    } // init

} // Swatch Class