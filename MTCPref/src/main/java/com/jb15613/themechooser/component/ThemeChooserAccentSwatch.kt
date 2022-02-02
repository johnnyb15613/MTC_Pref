package com.jb15613.themechooser.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout

import android.graphics.Color
import android.graphics.PorterDuff
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import com.jb15613.themechooser.mtcpref.R
import com.jb15613.themechooser.utility.ThemeChooserUtils

const val CHECKSTYLE_ACCENT_NORMAL = 0
const val CHECKSTYLE_ACCENT_CIRCLE = 1
const val CHECKSTYLE_ACCENT_SQUARE = 2
const val CHECKSTYLE_ACCENT_SWATCH = 3

/**
 * ## Class that creates an Accent Theme Swatch
 *
 * ### Extends [ConstraintLayout]
 *
 */
class ThemeChooserAccentSwatch : ConstraintLayout {

    private var mAttrs: AttributeSet? = null
    private var mColorAccent = 0
    private var mCheckStyle = 0

    private lateinit var mAccentCircle: ImageView
    private lateinit var mCheckmark: ImageView
    private lateinit var mColorText: TextView

    constructor(context: Context) : super(context) {
        initialize()
    } // constructor
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        mAttrs = attrs
        initialize(attrs)
    } // constructor
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        mAttrs = attrs
        initialize(attrs)
    } // constructor

    private fun initialize(vararg attrs: AttributeSet?) {

        LayoutInflater.from(context).inflate(R.layout.theme_chooser_accent_swatch_view, this, true)

        mAccentCircle = findViewById(R.id.accent_circle_image)
        mCheckmark = findViewById(R.id.checkmark_image)
        mColorText = findViewById(R.id.colorTextView)
        setIsChecked(false)

        val arraySize = attrs.size

        if (arraySize == 0) {
            // code usage
            setColorAccent(Color.GREEN)
        } else {
            // xml usage

            val attributes = attrs[0]

            context.theme.obtainStyledAttributes(attributes, R.styleable.ThemeChooserAccentSwatch, 0, 0).apply {
                try {
                    setColorAccent(getColor(R.styleable.ThemeChooserAccentSwatch_tcs_accent_color_accent, 0))
                    setCheckStyle(getInteger(R.styleable.ThemeChooserAccentSwatch_tcs_accent_check_style, 0))
                    setText(getString(R.styleable.ThemeChooserAccentSwatch_tcs_accent_color_name).toString())
                    setTextColor(getColor(R.styleable.ThemeChooserAccentSwatch_tcs_accent_text_color, 0))
                } finally {
                    recycle()
                }
            } // obtainStyledAttributes

        }

        mAccentCircle.setColorFilter(getColorAccent(), PorterDuff.Mode.MULTIPLY)

        when (getCheckStyle()) {
            CHECKSTYLE_ACCENT_NORMAL -> mCheckmark.setImageResource(R.drawable.checkmark)
            CHECKSTYLE_ACCENT_CIRCLE -> mCheckmark.setImageResource(R.drawable.circle_check)
            CHECKSTYLE_ACCENT_SQUARE -> mCheckmark.setImageResource(R.drawable.square_check)
            CHECKSTYLE_ACCENT_SWATCH -> mCheckmark.setImageResource(R.drawable.swatch_check)
        }

        if (isInEditMode) {
            mCheckmark.setColorFilter(0xFFFFFF, PorterDuff.Mode.SRC_IN)
        } else {
            mCheckmark.setColorFilter(ThemeChooserUtils.getPrimaryTextColor(), PorterDuff.Mode.SRC_IN)
        }


    } // initialize

    // from code
    fun setCheckmarkStyle(style: Int) {
        when (style) {
            CHECKSTYLE_ACCENT_NORMAL -> mCheckmark.setImageResource(R.drawable.checkmark)
            CHECKSTYLE_ACCENT_CIRCLE -> mCheckmark.setImageResource(R.drawable.circle_check)
            CHECKSTYLE_ACCENT_SQUARE -> mCheckmark.setImageResource(R.drawable.square_check)
            CHECKSTYLE_ACCENT_SWATCH -> mCheckmark.setImageResource(R.drawable.swatch_check)
        }
        mCheckmark.setColorFilter(ThemeChooserUtils.getPrimaryTextColor(), PorterDuff.Mode.SRC_IN)
    }

    // from code
    fun setIsChecked(value: Boolean) {
        mCheckmark.isVisible = value
    }

    // from code
    fun toggleChecked() {
        if (mCheckmark.isVisible) {
            mCheckmark.visibility = View.INVISIBLE
        } else {
            mCheckmark.visibility = View.VISIBLE
        }
    }

    // from code
    fun setAccentCircleColor(color: Int) {
        setColorAccent(color)
        mAccentCircle.setColorFilter(getColorAccent(), PorterDuff.Mode.MULTIPLY)
        invalidate()
    }

    fun setText(text: String) {
        mColorText.text = text
    }

    fun setTextColor(color: Int) {
        mColorText.setTextColor(color)
    }

    private fun setColorAccent(color: Int) {
        mColorAccent = color
    }

    private fun getColorAccent() : Int {
        return mColorAccent
    }

    private fun setCheckStyle(style: Int) {
        mCheckStyle = style
    }

    private fun getCheckStyle() : Int {
        return mCheckStyle
    }

} // ThemeChooserSwatch Class