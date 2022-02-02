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

const val CHECKSTYLE_NORMAL = 0
const val CHECKSTYLE_CIRCLE = 1
const val CHECKSTYLE_SQUARE = 2
const val CHECKSTYLE_SWATCH = 3

/**
 * ## Class that creates a Theme Swatch
 *
 * ### Extends [ConstraintLayout]
 *
 */
class ThemeChooserSwatch : ConstraintLayout {

    private var mAttrs: AttributeSet? = null
    private var mColorPrimary = 0
    private var mColorDark = 0
    private var mColorAccent = 0
    private var mCheckStyle = 0

    private lateinit var mAccentCircle: ImageView
    private lateinit var mPrimaryCircle: ImageView
    private lateinit var mDarkCircle: ImageView
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

        LayoutInflater.from(context).inflate(R.layout.theme_chooser_swatch_view, this, true)

        mAccentCircle = findViewById(R.id.bottom_circle_image)
        mPrimaryCircle = findViewById(R.id.middle_circle_image)
        mDarkCircle = findViewById(R.id.top_circle_image)
        mCheckmark = findViewById(R.id.checkmark_image)
        mColorText = findViewById(R.id.colorTextView)
        setIsChecked(false)

        val arraySize = attrs.size

        if (arraySize == 0) {
            // code usage
            setColorPrimary(Color.BLUE)
            setColorDark(Color.CYAN)
            setColorAccent(Color.GREEN)
        } else {
            // xml usage

            val attributes = attrs[0]

            context.theme.obtainStyledAttributes(attributes, R.styleable.ThemeChooserSwatch, 0, 0).apply {
                try {
                    setColorPrimary(getColor(R.styleable.ThemeChooserSwatch_tcs_color_primary, 0))
                    setColorDark(getColor(R.styleable.ThemeChooserSwatch_tcs_color_dark, 0))
                    setColorAccent(getColor(R.styleable.ThemeChooserSwatch_tcs_color_accent, 0))
                    setCheckStyle(getInteger(R.styleable.ThemeChooserSwatch_tcs_check_style, 0))
                    setText(getString(R.styleable.ThemeChooserSwatch_tcs_color_name).toString())
                    setTextColor(getColor(R.styleable.ThemeChooserSwatch_tcs_text_color, 0))
                } finally {
                    recycle()
                }
            } // obtainStyledAttributes

        }

        mPrimaryCircle.setColorFilter(getColorPrimary(), PorterDuff.Mode.MULTIPLY)
        mDarkCircle.setColorFilter(getColorDark(), PorterDuff.Mode.MULTIPLY)
        mAccentCircle.setColorFilter(getColorAccent(), PorterDuff.Mode.MULTIPLY)

        when (getCheckStyle()) {
            CHECKSTYLE_NORMAL -> mCheckmark.setImageResource(R.drawable.checkmark)
            CHECKSTYLE_CIRCLE -> mCheckmark.setImageResource(R.drawable.circle_check)
            CHECKSTYLE_SQUARE -> mCheckmark.setImageResource(R.drawable.square_check)
            CHECKSTYLE_SWATCH -> mCheckmark.setImageResource(R.drawable.swatch_check)
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
            CHECKSTYLE_NORMAL -> mCheckmark.setImageResource(R.drawable.checkmark)
            CHECKSTYLE_CIRCLE -> mCheckmark.setImageResource(R.drawable.circle_check)
            CHECKSTYLE_SQUARE -> mCheckmark.setImageResource(R.drawable.square_check)
            CHECKSTYLE_SWATCH -> mCheckmark.setImageResource(R.drawable.swatch_check)
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
    fun setPrimaryCircleColor(color: Int) {
        setColorPrimary(color)
        mPrimaryCircle.setColorFilter(getColorPrimary(), PorterDuff.Mode.MULTIPLY)
        invalidate()
    }

    // from code
    fun setDarkCircleColor(color: Int) {
        setColorDark(color)
        mDarkCircle.setColorFilter(getColorDark(), PorterDuff.Mode.MULTIPLY)
        invalidate()
    }

    // from code
    fun setAccentCircleColor(color: Int) {
        setColorAccent(color)
        mAccentCircle.setColorFilter(getColorAccent(), PorterDuff.Mode.MULTIPLY)
        invalidate()
    }

    // from code
    fun setAllCircleColors(colors: IntArray) {
        setPrimaryCircleColor(colors[0])
        setDarkCircleColor(colors[1])
        setAccentCircleColor(colors[2])
    }

    fun setText(text: String) {
        mColorText.text = text
    }

    fun setTextColor(color: Int) {
        mColorText.setTextColor(color)
    }

    private fun setColorPrimary(color: Int) {
        mColorPrimary = color
    }

    private fun getColorPrimary() : Int {
        return mColorPrimary
    }

    private fun setColorDark(color: Int) {
        mColorDark = color
    }

    private fun getColorDark() : Int {
        return mColorDark
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